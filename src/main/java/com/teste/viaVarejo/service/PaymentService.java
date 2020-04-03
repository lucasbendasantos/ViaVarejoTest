package com.teste.viaVarejo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.teste.viaVarejo.exception.ParcelLessThanOneException;
import com.teste.viaVarejo.exception.TotalAmountMadeException;
import com.teste.viaVarejo.exception.ValueBiggerThanException;
import com.teste.viaVarejo.exception.ValueExcpetion;
import com.teste.viaVarejo.model.Parcel;
import com.teste.viaVarejo.model.Payment;

/**
 * Classe processa um pedido
 * 
 * @author Lucas Bendassoli dos Santos
 */
@Service
public class PaymentService {

	@Value("${parcel.interest}")
	private int PARCEL_TO_INTEREST;

	@Autowired
	private TaxService tax;

	/**
	 * Método que processa o pagamento
	 * 
	 * @param payment Ordem de pagamento
	 * @return List<Parcel> lista de parcelas do pagamento
	 */
	public List<Parcel> execute(Payment payment) {
		this.validate(payment);

		Float orderValue = payment.getProduct().getValue() - payment.getPaymentCondition().getInitialPayment();

		if (payment.getPaymentCondition().getAmountParcel() < PARCEL_TO_INTEREST) {
			return this.getParcels(orderValue, payment.getPaymentCondition().getAmountParcel());
		} else {
			return this.getParcels(orderValue, payment.getPaymentCondition().getAmountParcel(), tax.getSelic());
		}
	}

	/**
	 * Executa o Parcelamento com a taxa Selic
	 * 
	 * @param value         Valor do pedido
	 * @param amountParcels Quantidade de parcelas
	 * @param tax           Taxa Selic considerada
	 * @return List<Parcel> Lista de parcelas
	 */
	public List<Parcel> getParcels(Float value, int amountParcels, Float tax) {
		List<Parcel> parcels = new ArrayList<Parcel>();

		Float finalValue = value + (value * ((tax / 100) * amountParcels));

		Float parcelValue = finalValue / amountParcels;

		for (int i = 1; i <= amountParcels; i++) {
			parcels.add(new Parcel(i, parcelValue, tax));
		}
		
		return parcels;
	}

	/**
	 * Executa o Parcelamento sem a taxa Selic
	 * 
	 * @param orderValue    Valor do pedido
	 * @param amountParcels Quantidade de parcelas
	 * @return List<Parcel> Parcelas
	 */
	public List<Parcel> getParcels(Float orderValue, int amountParcels) {
		List<Parcel> parcels = new ArrayList<Parcel>();

		Float parcelValue = orderValue / amountParcels;

		for (int i = 1; i <= amountParcels; i++) {
			parcels.add(new Parcel(i, parcelValue));
		}

		return parcels;
	}

	/**
	 * Valida o pagamento
	 * 
	 * @param payment pagamento do pedido
	 */
	private void validate(Payment payment) {

		if (payment.getPaymentCondition().getAmountParcel() < 1) {
			throw new ParcelLessThanOneException();
		}

		if (payment.getPaymentCondition().getInitialPayment() != null
				&& payment.getPaymentCondition().getInitialPayment() < 0) {
			throw new ValueExcpetion();
		}

		if (payment.getProduct().getValue() <= 0) {
			throw new ValueExcpetion();
		}

		if (payment.getPaymentCondition().getInitialPayment() != null
				&& (payment.getProduct().getValue() < payment.getPaymentCondition().getInitialPayment())) {
			throw new ValueBiggerThanException();
		}

		if (payment.getProduct().getValue().equals(payment.getPaymentCondition().getInitialPayment())) {
			throw new TotalAmountMadeException();
		}
	}

}

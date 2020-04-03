package com.teste.viaVarejo.model;


import javax.annotation.ManagedBean;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

/**
 * Classe informações de condição do pagamento
 * 
 * @author Lucas Bendassoli dos Santos
 */
@ManagedBean
@ApiModel(description = "Condição de pagamento")
public class PaymentCondition {
	 
	@JsonProperty("valorEntrada")
	private Float initialPayment;
	
	@JsonProperty("qtdeParcelas")
	private int amountParcel;

	public Float getInitialPayment() {
		return initialPayment != null ? initialPayment : 0;
	}

	public void setInitialPayment(Float initialPayment) {
		this.initialPayment = initialPayment;
	}

	public int getAmountParcel() {
		return amountParcel;
	}

	public void setAmountParcel(int amountParcel) {
		this.amountParcel = amountParcel;
	}

}

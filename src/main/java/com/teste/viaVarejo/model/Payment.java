package com.teste.viaVarejo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

/**
 * Classe de Parcelamento do pagamento
 * 
 * @author Lucas Bendassoli dos Santos
 */
@ApiModel(description = "Detalhes sobre a solicitação de parcelamento de pedido.")
public class Payment {
	
	@JsonProperty("produto")
	private Product product;
	
	@JsonProperty("condicaoPagamento")	
	private PaymentCondition paymentCondition;

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public PaymentCondition getPaymentCondition() {
		return paymentCondition;
	}

	public void setPaymentCondition(PaymentCondition paymentCondition) {
		this.paymentCondition = paymentCondition;
	}	

}

package com.teste.viaVarejo.enumerator;

public enum ValidatePaymentEnum {
	
	PARCEL_LESS_THAN("Parcela tem que ser maior ou igual a 1"),
	VALUES_LESS_THAN("Valor deve ser maior que 0"),
	VALUE_BIGGER_THEN("Valor maior que o valor do produto"),
	TOTAL_AMOUNT_MADE("Valor total da compra já foi efetuado");

	private String value;
	
	ValidatePaymentEnum(String value){
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}

package com.teste.viaVarejo.exception;

import com.teste.viaVarejo.enumerator.ValidatePaymentEnum;

public class ValueExcpetion extends BusinessException{

	private static final long serialVersionUID = 1696322086166307482L;

	public ValueExcpetion() {
		super(ValidatePaymentEnum.VALUES_LESS_THAN.getValue());
	}

}

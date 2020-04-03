package com.teste.viaVarejo.exception;

import com.teste.viaVarejo.enumerator.ValidatePaymentEnum;

public class ValueBiggerThanException extends BusinessException{

	private static final long serialVersionUID = 5482646688407766178L;

	public ValueBiggerThanException() {
		super(ValidatePaymentEnum.VALUE_BIGGER_THEN.getValue());
	}
}
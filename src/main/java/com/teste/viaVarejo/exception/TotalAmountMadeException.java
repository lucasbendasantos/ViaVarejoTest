package com.teste.viaVarejo.exception;

import com.teste.viaVarejo.enumerator.ValidatePaymentEnum;

public class TotalAmountMadeException extends BusinessException{

	private static final long serialVersionUID = -331245871143969222L;

	public TotalAmountMadeException() {
		super(ValidatePaymentEnum.TOTAL_AMOUNT_MADE.getValue());
	}

}

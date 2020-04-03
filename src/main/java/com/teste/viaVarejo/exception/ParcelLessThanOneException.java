package com.teste.viaVarejo.exception;

import com.teste.viaVarejo.enumerator.ValidatePaymentEnum;

public class ParcelLessThanOneException extends BusinessException {

	private static final long serialVersionUID = 4350432710994334386L;

	public ParcelLessThanOneException() {
		super(ValidatePaymentEnum.PARCEL_LESS_THAN.getValue());
	}
}

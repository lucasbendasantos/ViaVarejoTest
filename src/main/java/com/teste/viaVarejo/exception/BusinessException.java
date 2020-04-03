package com.teste.viaVarejo.exception;

public abstract class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -6048963774819148638L;

	public BusinessException(String message) {
		super(message);
	}
}
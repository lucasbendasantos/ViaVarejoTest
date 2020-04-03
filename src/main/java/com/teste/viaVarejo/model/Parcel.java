package com.teste.viaVarejo.model;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

/**
 * Classe que representa a parcela
 * 
 * @author Lucas Bendassoli dos Santos
 */
@ApiModel(description = "Parcelamento do pedido.")
public class Parcel {
	
	@NotNull
	@JsonProperty("numeroParcela")
	private int parcelNumber;
	
	@NotNull
	@JsonProperty("valor")
	private Float value;
	
	@NotNull
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("taxaJurosAoMes")
	private Float monthRate;
	
	public Parcel(int parcelNumber, Float value) {
		this.parcelNumber = parcelNumber;
		this.value = value;		
	}
	
	public Parcel(int parcelNumber, Float value, Float monthRate) {
		this.parcelNumber = parcelNumber;
		this.value = value;		
		this.monthRate = monthRate;
	}

	public int getParcelNumber() {
		return parcelNumber;
	}

	public void setParcelNumber(int parcelNumber) {
		this.parcelNumber = parcelNumber;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}

	public Float getMonthRate() {
		return monthRate;
	}

	public void setMonthRate(Float monthRate) {
		this.monthRate = monthRate;
	}

}

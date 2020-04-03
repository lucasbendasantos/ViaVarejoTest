package com.teste.viaVarejo.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;

/**
 * Classe Produtos dentro do pedido 
 * 
 * @author Lucas Bendassoli dos Santos
 */
@ApiModel(description = "Produto")
public class Product {
	
	@JsonProperty("codigo")
	private Long code;	
	
	@JsonProperty("nome")
	private String name;
	
	@JsonProperty("valor")
	private Float value;

	public Long getCode() {
		return code;
	}

	public void setCode(Long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getValue() {
		return value;
	}

	public void setValue(Float value) {
		this.value = value;
	}	

}

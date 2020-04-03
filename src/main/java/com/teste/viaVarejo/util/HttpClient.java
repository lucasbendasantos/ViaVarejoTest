package com.teste.viaVarejo.util;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Classe que faz a implemtacao do servico de HTTP
 */
@Component
public class HttpClient {

	/**
	 * Executa http get request
	 * @param url
	 * @param responseModel
	 * @return ResponseEntity<?
	 */
	public ResponseEntity<?> get(String url, Class<?> responseModel) {
		return new RestTemplate().getForEntity(url, responseModel);
	}
}


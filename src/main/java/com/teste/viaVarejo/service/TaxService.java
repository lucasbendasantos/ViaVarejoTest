package com.teste.viaVarejo.service;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.teste.viaVarejo.util.HttpClient;

/**
 * Classe consulta a taxa selic
 * 
 * @author Lucas Bendassoli dos Santos
 */
@Service
public class TaxService {

	@Autowired
	HttpClient http;

	@Value("${url.tax.selic}")
	private String URL;

	@Value("${average.selic}")
	private Double AVERAGE_SELIC;

	/**
	 * Método que retorna webservice a taxa selic do dia corrente (caso não consiga
	 * acessar o webservice, ele pega a média da variavel de ambiente)
	 * 
	 * @return Float taxa selic
	 */
	public Float getSelic() {
		try {
			LocalDate today = LocalDate.now();
			JsonNode root, value;
			ObjectMapper mapper = new ObjectMapper();

			DateTimeFormatter formater = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String period = "&dataInicial=" + today.format(formater) + "&dataFinal=" + today.format(formater);
			ResponseEntity<String> response = (ResponseEntity<String>) http.get(URL + period, String.class);
			root = mapper.readTree(response.getBody());

			return Double.valueOf(root.findPath("valor").asDouble()).floatValue();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Caso o servico não responda
		return AVERAGE_SELIC.floatValue();
	}
}

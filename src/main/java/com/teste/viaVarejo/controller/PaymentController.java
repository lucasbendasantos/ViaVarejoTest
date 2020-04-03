package com.teste.viaVarejo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.viaVarejo.model.Parcel;
import com.teste.viaVarejo.model.Payment;
import com.teste.viaVarejo.service.PaymentService;

import io.swagger.annotations.ApiParam;

/**
 * Classe que representa o pagamento de um pedido
 * @author Lucas Bendassoli dos Santos
 */
@RestController
@RequestMapping(value = "/api/payment")
public class PaymentController {
	
	@Autowired
	private PaymentService paymentService;	
	
	@PostMapping(produces = "application/json")
	public ResponseEntity<List<Parcel>> executePayment(
			@ApiParam(value = "Endpoint de pagamento", required = true) @Valid @RequestBody Payment payment) {
		
		return ResponseEntity.ok().body(this.paymentService.execute(payment));
	}

}

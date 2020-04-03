package com.teste.viaVarejo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.util.ReflectionTestUtils;

import com.teste.viaVarejo.exception.ParcelLessThanOneException;
import com.teste.viaVarejo.exception.TotalAmountMadeException;
import com.teste.viaVarejo.exception.ValueBiggerThanException;
import com.teste.viaVarejo.exception.ValueExcpetion;
import com.teste.viaVarejo.model.Parcel;
import com.teste.viaVarejo.model.Payment;
import com.teste.viaVarejo.model.PaymentCondition;
import com.teste.viaVarejo.model.Product;

public class PaymentServiceTest {
	
	@Mock
	TaxService taxService;
	
	@InjectMocks
	PaymentService service;
	
	Payment payment;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		ReflectionTestUtils.setField(service, "PARCEL_TO_INTEREST", 6);
		
		payment = new Payment();
		PaymentCondition condition = new PaymentCondition();
		condition.setAmountParcel(5);
		condition.setInitialPayment(200F);
		
		Product product = new Product();
		product.setCode(1L);
		product.setName("Televisão Tela Plana");
		product.setValue(2500F);
		
		payment.setPaymentCondition(condition);
		payment.setProduct(product);
	}

	@Test
	public void testExecuteWithoutSelicTax() {
		List<Parcel> response = service.execute(payment);
		assertEquals(response.size(), 5);
		assertEquals(response.get(0).getValue(),new Float(460.0));
	}
	
	@Test
	public void testExecuteWithSelicTax() {
		payment.getPaymentCondition().setAmountParcel(10);
		when(taxService.getSelic()).thenReturn(0.014227F);
		List<Parcel> response = service.execute(payment);
		assertEquals(response.size(), 10);
	}
	
	@Test(expected = ParcelLessThanOneException.class)
	public void testExceptionAmountParcel() {
		payment.getPaymentCondition().setAmountParcel(0);
		List<Parcel> response = service.execute(payment);
	}
	
	@Test(expected = ValueExcpetion.class)
	public void testExceptionValueInitialPayment() {
		payment.getPaymentCondition().setInitialPayment(-10F);
		List<Parcel> response = service.execute(payment);
	}
	
	@Test(expected = ValueExcpetion.class)
	public void testExceptionValueProductPayment() {
		payment.getProduct().setValue(-10F);
		List<Parcel> response = service.execute(payment);
	}
	
	@Test(expected = ValueBiggerThanException.class)
	public void testExceptionLessThanValueProductPayment() {
		payment.getProduct().setValue(10F);
		payment.getPaymentCondition().setInitialPayment(200F);
		List<Parcel> response = service.execute(payment);
	}
	
	@Test(expected = TotalAmountMadeException.class)
	public void testExceptionValueEqualsInitialPayment() {
		payment.getProduct().setValue(200F);
		payment.getPaymentCondition().setInitialPayment(200F);
		List<Parcel> response = service.execute(payment);
	}
	

}

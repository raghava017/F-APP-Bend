package com.cigniti.foodApp.controller;

import com.cigniti.foodApp.entity.Payment;
import com.cigniti.foodApp.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/payments")
public class PaymentController {

	@Autowired
	PaymentService paymentService;

	@GetMapping("/list")
	public List<Payment> getAllPayments() {

		List<Payment> paymentsList = paymentService.getAllPayments();
		return paymentsList;

	}

	@PostMapping("/save")
	public Payment savePayment(@RequestBody Payment payment) {
		paymentService.savePayment(payment);

		return payment;

	}

	@PutMapping("/edit")
	public Payment updatePayment(@RequestBody Payment payment) {
		paymentService.savePayment(payment);

		return payment;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		Payment payment = paymentService.findByPaymentId(id);
		if (payment == null) {
			throw new RuntimeException("Payment not found with id" + id);
		}

		paymentService.deleteByPaymentId(id);
		return "Deleted payment with id :" + id;
	}

}

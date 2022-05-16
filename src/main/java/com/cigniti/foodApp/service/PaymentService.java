package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.Payment;

import java.util.List;

public interface PaymentService {

	public List<Payment> getAllPayments();

	public Payment savePayment(Payment payment);

	public Payment findByPaymentId(int id);

	public void deleteByPaymentId(int id);

}

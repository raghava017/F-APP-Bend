package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.Payment;
import com.cigniti.foodApp.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentSeviceImpl implements PaymentService {

	@Autowired
	PaymentRepository paymentRepo;

	@Override
	public List<Payment> getAllPayments() {
		List<Payment> paymentsList = paymentRepo.findAll();
		return paymentsList;
	}

	@Override
	public Payment savePayment(Payment payment) {
		paymentRepo.save(payment);
		return payment;
	}

	@Override
	public Payment findByPaymentId(int id) {
		Optional<Payment> result = paymentRepo.findById(id);
		Payment payment = null;

		if (result.isPresent()) {
			payment = result.get();
		} else {
			throw new RuntimeException("Could not find by Id:" + id);
		}
		return payment;
	}

	@Override
	public void deleteByPaymentId(int id) {
		paymentRepo.deleteById(id);

	}

}

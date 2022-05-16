package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.OrderDetails;
import com.cigniti.foodApp.repository.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OderDetailsServiceImpl implements OrderDetailsService {

	@Autowired
	OrderDetailsRepository odRepo;

	@Override
	public List<OrderDetails> getAllOrderDetails() {
		List<OrderDetails> orderDetailsList = odRepo.findAll();
		return orderDetailsList;
	}

	@Override
	public OrderDetails saveOrderDetails(OrderDetails orderDetails) {
		odRepo.save(orderDetails);
		return orderDetails;
	}

	@Override
	public OrderDetails findByOrderDetailsId(int id) {
		Optional<OrderDetails> result = odRepo.findById(id);
		OrderDetails orderDetails = null;

		if (result.isPresent()) {
			orderDetails = result.get();
		} else {
			throw new RuntimeException("Could not find by Id:" + id);
		}
		return orderDetails;
	}

	@Override
	public void deleteByOrderDetailsId(int id) {
		odRepo.deleteById(id);

	}

}

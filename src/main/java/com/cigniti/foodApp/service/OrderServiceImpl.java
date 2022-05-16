package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.Order;
import com.cigniti.foodApp.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository orderRepo;

	@Override
	public List<Order> getAllOrders() {
		List<Order> orders = orderRepo.findAll();
		return orders;
	}

	@Override
	public Order saveOrder(Order order) {
		orderRepo.save(order);
		return order;
	}

	@Override
	public Order findByOrderId(int orderId) {
		Optional<Order> result = orderRepo.findById(orderId);
		Order order = null;

		if (result.isPresent()) {
			order = result.get();
		} else {
			throw new RuntimeException("Could not find by Id:" + orderId);
		}
		return order;
	}

	@Override
	public void deleteByOrderId(int orderId) {
		orderRepo.deleteById(orderId);

	}

}

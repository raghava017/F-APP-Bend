package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.OrderDetails;

import java.util.List;

public interface OrderDetailsService {

	public List<OrderDetails> getAllOrderDetails();
	public OrderDetails saveOrderDetails(OrderDetails orderDetails);
	public OrderDetails findByOrderDetailsId(int id);
	public void deleteByOrderDetailsId(int id);
	
}

package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.Order;

import java.util.List;

public interface OrderService {
	
	public List<Order> getAllOrders();
	public Order saveOrder(Order order);
	public Order findByOrderId(int orderId);
	public void deleteByOrderId(int orderId);
	

}

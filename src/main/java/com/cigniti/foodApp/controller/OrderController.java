package com.cigniti.foodApp.controller;

import com.cigniti.foodApp.entity.Order;
import com.cigniti.foodApp.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/orders")
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping("/list")
	public List<Order> getAllOrders() {

		List<Order> orders = orderService.getAllOrders();
		return orders;

	}

	@PostMapping("/save")
	public Order saveOrder(@RequestBody Order order) {
		orderService.saveOrder(order);

		return order;

	}

	@PutMapping("/edit")
	public Order updateOrder(@RequestBody Order order) {
		orderService.saveOrder(order);

		return order;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		Order order = orderService.findByOrderId(id);
		if (order == null) {
			throw new RuntimeException("Order not found with id" + id);
		}

		orderService.deleteByOrderId(id);
		return "Deleted order with id :" + id;
	}

}

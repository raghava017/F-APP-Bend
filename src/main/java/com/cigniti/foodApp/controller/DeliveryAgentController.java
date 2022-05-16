package com.cigniti.foodApp.controller;

import com.cigniti.foodApp.entity.DeliveryAgent;
import com.cigniti.foodApp.service.DeliveryAgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/deliveryAgents")
public class DeliveryAgentController {

	@Autowired
	DeliveryAgentService daService;

	@GetMapping("/list")
	public List<DeliveryAgent> getAllDeliveryAgents() {

		List<DeliveryAgent> deliveryAgents = daService.getAllDeliveryAgents();
		return deliveryAgents;

	}

	@PostMapping("/save")
	public DeliveryAgent saveDeliveryAgent(@RequestBody DeliveryAgent deliveryAgent) {
		daService.saveDeliveryAgent(deliveryAgent);

		return deliveryAgent;

	}

	@PutMapping("/edit")
	public DeliveryAgent updateDeliveryAgent(@RequestBody DeliveryAgent deliveryAgent) {
		daService.saveDeliveryAgent(deliveryAgent);

		return deliveryAgent;
	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {

		DeliveryAgent deliveryAgent = daService.getDeliveryAgentById(id);
		if (deliveryAgent == null) {
			throw new RuntimeException("DeliveryAgent not found with id" + id);
		}

		daService.deleteDeliveryAgentById(id);
		return "Deleted DeliveryAgent with id :" + id;
	}

}

package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.DeliveryAgent;
import com.cigniti.foodApp.repository.DeliveryAgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryAgentServiceImpl implements DeliveryAgentService {

	@Autowired
	DeliveryAgentRepository daRepo;

	@Override
	public List<DeliveryAgent> getAllDeliveryAgents() {
		List<DeliveryAgent> deliveryAgents = daRepo.findAll();
		return deliveryAgents;
	}

	@Override
	public DeliveryAgent saveDeliveryAgent(DeliveryAgent deliveryAgent) {
		daRepo.save(deliveryAgent);
		return deliveryAgent;
	}

	@Override
	public DeliveryAgent getDeliveryAgentById(int id) {
		Optional<DeliveryAgent> result = daRepo.findById(id);
		DeliveryAgent deliveryAgent = null;

		if (result.isPresent()) {
			deliveryAgent = result.get();
		} else {
			throw new RuntimeException("Could not find by Id:" + id);
		}
		return deliveryAgent;
	}

	@Override
	public void deleteDeliveryAgentById(int id) {
		daRepo.deleteById(id);
	}

}

package com.cigniti.foodApp.service;

import com.cigniti.foodApp.entity.DeliveryAgent;

import java.util.List;

public interface DeliveryAgentService {
	
	public List<DeliveryAgent> getAllDeliveryAgents();
	public DeliveryAgent saveDeliveryAgent(DeliveryAgent deliveryAgent);
	public DeliveryAgent getDeliveryAgentById(int id);
	public void deleteDeliveryAgentById(int id);
	
	

}

package com.alom.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.alom.model.Customer;
import com.alom.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemplate;
	
	@Override
	public String addCustomersDetails(List<Customer> customers) {
		if (customers != null) {
			for(Customer customer : customers) {
				kafkaTemplate.send("customer", customer);
				
				System.out.println("******************** Message puclished to kafka topic ********************");
			}
		}
		
		return "Successfully added customer details.";
	}

}

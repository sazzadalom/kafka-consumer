package com.alom;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.alom.bean.Customer;

@Service("consumerService")
public class ConsumerService {
/**
 * This method is cotinuously listening from kafka broker
 * 
 * @param customer
 * @return
 */
	@KafkaListener(topics = "customer", groupId = "group_customer")
	public Customer customerListener(Customer customer) {
		System.out.println("******************** Messae recieved from kafka topic :: " + customer + " ********************");
		return customer;
	}
}

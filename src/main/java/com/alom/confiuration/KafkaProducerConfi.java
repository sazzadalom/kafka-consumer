package com.alom.confiuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.alom.model.Customer;

@Configuration
public class KafkaProducerConfi {

	/**
	 * This method is used to KAFKA producer configuration details 
	 * @return
	 */
	
	@Bean
	public ProducerFactory<String, Customer> producerFactory(){
		Map<String, Object> confiProps = new HashMap<>();
		confiProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		confiProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		confiProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
		return new DefaultKafkaProducerFactory<String, Customer>(confiProps);
		
	}
	
	/**
	 * This method is used for create kafkaTemplate bean
	 * @return
	 * 
	 */
	
	@Bean(name = "kafkaTemplate")
	public KafkaTemplate<String, Customer> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
		
		
	}
	
	
	
}

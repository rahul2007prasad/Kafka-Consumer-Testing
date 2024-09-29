package com.rahul.kafka.consumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import com.rahul.kafka.consumer.dto.Customer;



@Service
@EnableKafka
public class KafkaMessageListnerService {
	
	Logger log = LoggerFactory.getLogger(KafkaMessageListnerService.class);
	

	/*
	 * @KafkaListener(topics = "rahul-topic-4" , groupId = "rahul-group1") public
	 * void consume(String message) { log.info("Consumer0 consume the "+message); }
	 * 
	 * @KafkaListener(topics = "rahul-topic-4" , groupId = "rahul-group1") public
	 * void consume1(String message) { log.info("Consumer1 consume the "+message); }
	 * 
	 * @KafkaListener(topics = "rahul-topic-4" , groupId = "rahul-group1") public
	 * void consume2(String message) { log.info("Consumer2 consume the "+message); }
	 * 
	 * @KafkaListener(topics = "rahul-topic-4" , groupId = "rahul-group1") public
	 * void consume3(String message) { log.info("Consumer3 consume the "+message); }
	 * 
	 * @KafkaListener(topics = "rahul-topic-4" , groupId = "rahul-group1") public
	 * void consume4(String message) { log.info("Consumer4 consume the "+message); }
	 */
	
	@KafkaListener(topics = "customer" , groupId = "customer-group")
	public void consume(@Payload String customer) {
		//System.out.println("hello "+customer.getContactNum());
		log.info("Consumer consume the events started " + customer.toString());
		/*
		 * log.info("Consumer consume the "+customer.getContactNum());
		 * log.info("Consumer consume the "+customer.getEmail());
		 * log.info("Consumer consume the "+customer.getName());
		 * log.info("Consumer consume the "+customer.getContactNum());
		 */
		
		
	}
	
	
	/*
	 * message listner for particular partition
	 */
	@KafkaListener(topics = "customer-partition" , groupId = "customer-partition")
	public void consumePartition(@Payload Customer customer) {
		log.info("Consumer consume the "+customer);
	}
}

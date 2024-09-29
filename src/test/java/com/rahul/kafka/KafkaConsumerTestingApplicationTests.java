package com.rahul.kafka;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.core.KafkaTemplate;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.rahul.kafka.consumer.dto.Customer;

import lombok.extern.slf4j.Slf4j;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Testcontainers
@Slf4j
class KafkaConsumerTestingApplicationTests {
	Logger log = LoggerFactory.getLogger(KafkaConsumerTestingApplicationTests.class);
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	@Test
	public void testConsumeEvents() {
		log.info("Consumer consume the events started ");
		Customer customer = new Customer(250,"test_user","test@gmail.com","76578456");
		kafkaTemplate.send("customer" , customer);
		log.info("Consumer consume the events ended ");
		Awaitility
		.await()
		.pollInterval(Duration.ofSeconds(3))
		.atMost(10,TimeUnit.SECONDS)
		.untilAsserted(() -> {
			//if any assert statement
		});
	}

}

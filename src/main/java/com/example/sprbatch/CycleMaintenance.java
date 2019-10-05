package com.example.sprbatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;



@SpringBootApplication
public class CycleMaintenance {

	public static void main(String[] args) {
		SpringApplication.run(CycleMaintenance.class, args);

	}
	

}

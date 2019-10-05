package com.example.sprbatch.step;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.batch.core.annotation.OnReadError;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;
import org.springframework.batch.item.kafka.KafkaItemReader;
import org.springframework.batch.item.kafka.builder.KafkaItemReaderBuilder;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.sprbatch.model.BillingCycleInstanceNotification;

import java.util.Properties;


public class Reader {

	public static KafkaItemReader<Long, String> reader(){

	Properties props = new Properties();
	props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,
	        "eaasrt1:9092");
	    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,
	    		org.apache.kafka.common.serialization.StringDeserializer.class);
	   // props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,
	  //  		org.springframework.kafka.support.serializer.JsonDeserializer.class);
	    // allows a pool of processes to divide the work of consuming and processing records
	    props.put(ConsumerConfig.GROUP_ID_CONFIG, "helloworld");
	    // automatically reset the offset to the latest offset
	    //somehow this does not work - it gives from beginning all the time
	    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "latest");
	    
	    //The offset was not being committed
	    props.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, 1);
	  //  props.put(JsonDeserializer.USE_TYPE_INFO_HEADERS, false);
	  //  props.put(JsonDeserializer.VALUE_DEFAULT_TYPE,com.amdocs.charging.cyclemaint.model.BillingCycleInstanceNotification.class);
	    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.StringDeserializer.class);
	    
	    
	//props.putAll(properties.buildConsumerProperties());	
	    KafkaItemReader<Long, String> reader =  new KafkaItemReaderBuilder<Long, String>()
			.partitions(0)
			.consumerProperties(props)
			.name("cycle-reader")
			.saveState(true)
			.topic("cycle")
			.build();
	    
	    	    
	    return reader;
}

	
	
	
}
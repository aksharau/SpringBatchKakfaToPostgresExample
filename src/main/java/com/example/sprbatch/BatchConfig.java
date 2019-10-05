package com.example.sprbatch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.sprbatch.dao.CycleInstanceDao;
import com.example.sprbatch.model.BillingCycleInstanceNotification;
import com.example.sprbatch.model.CycleInstance;
import com.example.sprbatch.step.Listener;
import com.example.sprbatch.step.Processor;
import com.example.sprbatch.step.Reader;
import com.example.sprbatch.step.Writer;

	
	@Configuration
	@EnableBatchProcessing
	public class BatchConfig extends DefaultBatchConfigurer  {

		@Autowired
		public JobBuilderFactory jobBuilderFactory;

		@Autowired
		public StepBuilderFactory stepBuilderFactory;

		@Autowired
		public CycleInstanceDao cycleInstanceDao;

		@Bean
		public Job job() {
			return jobBuilderFactory.get("job").incrementer(new RunIdIncrementer())
					.flow(step1()).end().build();
		}

		@Bean
		public Step step1() {
			return stepBuilderFactory.get("step").<String, CycleInstance>chunk(1)
					.reader(Reader.reader()).listener(new Listener())
					.processor(new Processor()).writer(new Writer(cycleInstanceDao)).build();
		}
		
		 	@Override
		    public void setDataSource(DataSource dataSource) {
		        // override to do not set datasource even if a datasource exist.
		        // initialize will use a Map based JobRepository (instead of database)
		    }
		 
}

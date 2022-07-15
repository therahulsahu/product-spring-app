//package com.product.config;
//
//import java.io.IOException;
//
//import org.camunda.bpm.engine.spring.ProcessEngineFactoryBean;
//import org.camunda.bpm.engine.spring.SpringProcessEngineConfiguration;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class CamundaProcessEngineConfig {
//	
//	@Bean
//	  public SpringProcessEngineConfiguration processEngineConfiguration() throws IOException {
//	    SpringProcessEngineConfiguration config = new SpringProcessEngineConfiguration();
//	    return config;
//	  }
//	
//	@Bean
//	  public ProcessEngineFactoryBean processEngine() throws IOException {
//	    ProcessEngineFactoryBean factoryBean = new ProcessEngineFactoryBean();
//	    factoryBean.setProcessEngineConfiguration(processEngineConfiguration());
//	    return factoryBean;
//	  }
//	
//
//}
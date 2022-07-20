package com.product.service;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import com.product.model.CreateProductDelegate;


@Component
public class CamundaService {
	private final Logger LOGGER = LoggerFactory.getLogger(CreateProductDelegate.class.getName());

    public void saveData(DelegateExecution execution) throws Exception {
        String productService = (String) execution.getVariable("product");

        LOGGER.info("Product Service Process: " + execution.getCurrentActivityName() + " - " + productService);
    }

}

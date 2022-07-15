package com.product.model;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("getProduct")
public class GetProductDelegate implements JavaDelegate {

    private final Logger LOGGER = LoggerFactory.getLogger(CreateProductDelegate.class.getName());

    public void execute(DelegateExecution execution) throws Exception {
        String productService = (String) execution.getVariable("product");

        LOGGER.info("Product Service process: " + execution.getCurrentActivityName() + " - " + productService);
    }
}
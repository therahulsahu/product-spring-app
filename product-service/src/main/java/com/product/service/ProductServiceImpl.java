package com.product.service;

import java.util.List;
import java.util.Optional;
import java.util.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.product.model.Product;
import com.product.repository.ProductRepository;

@Service
@Qualifier("ProductService")
@Slf4j
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	ProductRepository productRepository;

	@Autowired
	KafkaTemplate<String, Product> kafkaTemplate;

	private static final String TOPIC = "product_topic";
	
	public List<Product> getProductList() {
		List<Product> products = productRepository.findAll();
		if(products.size() == 0) {
			Product product1 = new Product("1", "Apple Iphone 13", "60000", "128GB storage, 8GB Ram", "10", false);
			Product product2 = new Product("2", "Samsung Galaxy S21", "50000", "256GB storage, 8GB Ram", "10", false);
			Product product3 = new Product("3", "VIVO V9 Pro", "45000", "128GB storage, 6GB Ram", "12", false);
			
			products.add(product1);
			products.add(product2);
			products.add(product3);
		}
		try {
			log.info("Getting product {}",new ObjectMapper().writeValueAsString(products));
		} catch (JsonProcessingException e) {
			log.error("error while getting product {}",e);
			e.printStackTrace();
		}
		return products;
	}
	
	public boolean createProducts(List<Product> productList) {
		try {
			productRepository.saveAll(productList);
//			productList.forEach(product -> kafkaTemplate.send(TOPIC, product));
			log.info("Published to topic : " + TOPIC);
			log.info("Adding product {}",new ObjectMapper().writeValueAsString(productList));
		}
		catch (IllegalArgumentException e) {
			// In case the given entities or any of the entities is null.
			log.error("error while adding product {}",e);
			return false;
		}
		catch (JsonProcessingException e) {
			log.error("error while adding product  {}",e);
			e.printStackTrace();
		}
		return true;
	}
	
	public boolean deleteProducts(List<Product> productList) {
		try {
			productRepository.deleteAll(productList);
			log.info("Deleting product {}",new ObjectMapper().writeValueAsString(productList));
		}
		catch (Exception e) {
			// In case the given entities or any of the entities is null.
			// or the given id is not found
			log.error("Product could not be deleted : {}",e);
			return false;
		}
		return true;
	}

	public boolean updateProduct(Product updatedProduct) {
		Optional<Product> optionalProduct = productRepository.findById(updatedProduct.getProductId());
		if(optionalProduct.isEmpty()) {
			System.out.println("No product found with id : " + updatedProduct.getProductId());
			return false;
		}

		Product currentProduct = optionalProduct.get();
		copyProductProperties(currentProduct, updatedProduct);
		productRepository.save(currentProduct);
		try {
			log.info("Adding product {}",new ObjectMapper().writeValueAsString(Collections.singletonList(updatedProduct)));
		} catch (JsonProcessingException e) {
			log.error("Product could not be updated : {}",e);
			e.printStackTrace();
		}
		return true;
	}

	private void copyProductProperties(Product productA, Product productB) {
		if(productB.getProductName() != null) {
			productA.setProductName(productB.getProductName());
		}
		if(productB.getProductPrice() != null) {
			productA.setProductPrice(productB.getProductPrice());
		}
		if(productB.getProductDesc() != null) {
			productA.setProductDesc(productB.getProductDesc());
		}
		if(productB.getProductQuantity() != null) {
			productA.setProductQuantity(productB.getProductQuantity());
		}
		if(productB.getProductType() != null) {
			productA.setProductType(productB.getProductType());
		}
		if(productB.getProductmul() != null) {
			productA.setProductmul(productB.getProductmul());
		}
	}
	
	public long getProductsCount() {
		log.info("Product count {}",productRepository.count());
		return productRepository.count();
	}
}

package com.msi.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.msi.model.Customer;
import com.msi.model.Product;

@Service
public class ProductService {
	private final KieContainer kieContainer;

	@Autowired
	public ProductService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public Product getProductDiscount(Product product, Customer customer) {
		//get the stateful session
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(product);
		kieSession.insert(customer);
		kieSession.setGlobal("ProductService", this);
		kieSession.fireAllRules();
		kieSession.dispose();
		return product;
	}
	
	public void printMsg() {
		System.out.println("dsf");
	}


}
	

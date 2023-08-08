package com.palma.ecommerceArte.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import com.github.javafaker.Faker;
//import com.palma.ecommerceArte.auth.entity.User;
import com.palma.ecommerceArte.model.Client;
import com.palma.ecommerceArte.model.Product;
import com.palma.ecommerceArte.service.ProductService;
import java.util.*;

@Configuration
public class ClientConfiguration {
	
	@Autowired ProductService productService;
	
	@Bean("clientRandom")
	@Scope("prototype")
	public Client clientRandom() {
		
		List<Product> products = new ArrayList<>();
		products.add(productService.getProductRandom());		
		Faker fake = new Faker();
		
		return Client.builder()
				.name(fake.name().firstName())
				.lastname(fake.name().lastName())
				.number(fake.phoneNumber().cellPhone())
				.email(fake.internet().emailAddress())
				.products(products)
				.user(null)
				.build();
	}		
}

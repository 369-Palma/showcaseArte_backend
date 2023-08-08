package com.palma.ecommerceArte.configuration;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;

import com.palma.ecommerceArte.beans.ProductSea1Bean;
import com.palma.ecommerceArte.beans.ProductSea2Bean;
import com.palma.ecommerceArte.beans.ProductSea3Bean;
import com.palma.ecommerceArte.beans.ProductSea4Bean;
import com.palma.ecommerceArte.beans.ProductSea5Bean;
import com.palma.ecommerceArte.beans.ProductSea6Bean;
import com.palma.ecommerceArte.beans.ProductSea7Bean;
import com.palma.ecommerceArte.beans.ProductSea8Bean;
import com.palma.ecommerceArte.beans.ProductSea9Bean;
import com.palma.ecommerceArte.beans.ProductCustom1Bean;
import com.palma.ecommerceArte.beans.ProductFlowers1Bean;
import com.palma.ecommerceArte.beans.ProductFlowers2Bean;
import com.palma.ecommerceArte.beans.ProductOysters1Bean;
import com.palma.ecommerceArte.beans.ProductOysters2Bean;
import com.palma.ecommerceArte.beans.ProductSea10Bean;
import com.palma.ecommerceArte.beans.ProductSea11Bean;
import com.palma.ecommerceArte.model.Client;
import com.palma.ecommerceArte.model.Collection;
import com.palma.ecommerceArte.model.Product;
import com.palma.ecommerceArte.service.ClientService;

import jakarta.annotation.PostConstruct;

@Configuration
public class ProductConfiguration {

	@Autowired ClientService clientService;
	@Autowired ProductSea1Bean product1;
	@Autowired ProductSea2Bean product2;
	@Autowired ProductSea3Bean product3;
	@Autowired ProductSea4Bean product4;
	@Autowired ProductSea5Bean product5;
	@Autowired ProductSea6Bean product6;
	@Autowired ProductSea7Bean product7;
	@Autowired ProductSea8Bean product8;
	@Autowired ProductSea9Bean product9;
	@Autowired ProductSea10Bean product10;
	@Autowired ProductSea11Bean product11;
	
	@Autowired ProductOysters1Bean productOyster1;
	@Autowired ProductOysters2Bean productOyster2;
	
	@Autowired ProductFlowers1Bean productFlowers1;
	@Autowired ProductFlowers2Bean productFlowers2;
	
	@Autowired ProductCustom1Bean productCustom1;
	
	private boolean setIsAvailable(Client client) {
        return client == null;
    }
	
	
	@Bean("ProductSea1")
	@Scope("singleton")
	
	public Product ProductSea1()  throws IOException{
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("The quiet after the storm")
				.price(450d)
				.length(30d)
				.width(24d)
				.description("Acrylic on canvas. \r\n"
						+ "The tone is mainely turquoise and deep blue. "
						+ "This painting is painted dark blue around the sides. \r\n"	
						+ "It has been given a coat of high gloss varnish to protect and preserve it. \r\n"
						+ "Local pick-up only. Delivery within 50 km can be arranged.")
				.collection(Collection.Seascapes)
				.img(product1.getImageUrlFromFile())
				.available(isAvailable)
				.build();
	}
	
	
	@Bean("ProductSea2")
	@Scope("singleton")
	
	public Product ProductSea2() throws IOException{
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Shoreline from above")
				.price(350d)
				.length(50d)
				.width(30d)
				.description("Acrylic on canvas. \r\n"
						+ "The painting is painted white around the sides. \r\n"
						+ "It has been given a coat of high gloss varnish to protect and preserve it. r\n"
						+ "Local pick-up only. Delivery within 50 km can be arranged.")
				.collection(Collection.Seascapes)
				.img(product2.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	

	@Bean("ProductSea3")
	@Scope("singleton")
	
	public Product ProductSea3() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Winter sea")
				.price(550d)
				.length(30d)
				.width(25d)
				.description("Acrylic on canvas. \r\n"
						+ "The tone is light blue and gold."
						+ "This canvas is painted gold around the sides. \r\n"
						+ "It has been given a coat of high gloss varnish to protect and preserve it. r\n"
						+ "Local pick-up only. Delivery within 50 km can be arranged.")
				.collection(Collection.Seascapes)
				.img(product3.getImageUrlFromFile())
				.available(isAvailable)
				.build();
	}
	

	@Bean("ProductSea4")
	@Scope("singleton")
	
	public Product ProductSea4() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Carribean morning")
				.price(1650d)
				.length(40d)
				.width(40d)
				.description("Acrylic on canvas. \r\n"
						+ "The tone is predominantly yellow and turquoise."
						+ "This canvas is painted yellow around the sides. \r\n"
						+ "It has been given a coat of high gloss varnish to protect and preserve it. r\n"
						+ "Local pick-up only. Delivery within 50 km can be arranged.")
				.collection(Collection.Seascapes)
				.img(product4.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	
	@Bean("ProductSea5")
	@Scope("singleton")
	
	public Product ProductSea5() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Wave")
				.price(250d)
				.length(30d)
				.width(30d)
				.description("Flat canvas, acrylic.\r\n"
						+ "It has been given a coat of high gloss varnish to protect and preserve it. r\n"
						+ "Local pick-up only. Delivery within 50 km can be arranged.")
				.collection(Collection.Seascapes)
				.img(product5.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	
	@Bean("ProductSea6")
	@Scope("singleton")
	
	public Product ProductSea6() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Commissioned by Jenny")
				.price(0d)
				.length(30d)
				.width(20d)
				.description("Acrylic on canvas")
				.collection(Collection.Commissioned)
				.img(product6.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	
	@Bean("ProductSea7")
	@Scope("singleton")
	
	public Product ProductSea7() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Sailboat at sunset")
				.price(890d)
				.length(30d)
				.width(30d)
				.description("Flat canvas, acrylic.\r\n"
						+ "The tone is predominantly"
						+ "It has been given a coat of high gloss varnish to protect and preserve it. r\n"
						+ "Local pick-up only. Delivery within 50 km can be arranged.")
				.collection(Collection.Seascapes)
				.img(product7.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	
	@Bean("ProductSea8")
	@Scope("singleton")
	
	public Product ProductSea8() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Windy day at the sea")
				.price(750d)
				.length(30d)
				.width(70d)
				.description("Acrylic on canvas. \r\n"
						+ "The tone is predominantly blue."
						+ "This canvas is painted white around the sides. \r\n"
						+ "It has been given a coat of high gloss varnish to protect and preserve it. r\n"
						+ "Local pick-up only. Delivery within 50 km can be arranged.")
				.collection(Collection.Seascapes)
				.img(product8.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	
	@Bean("ProductSea9")
	@Scope("singleton")
	
	public Product ProductSea9() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Bright morning")
				.price(850d)
				.length(40d)
				.width(50d)
				.description("Acrylic on canvas. \r\n"
						+ "The tone is predominantly yellow and light blue."
						+ "This painting is painted yellow around the sides. \r\n"
						+ "It has been given a coat of high gloss varnish to protect and preserve it. r\n"
						+ "Local pick-up only. Delivery within 50 km can be arranged.")
				.collection(Collection.Seascapes)
				.img(product9.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	
	
	@Bean("ProductSea10")
	@Scope("singleton")
	
	public Product ProductSea10() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Orange sunset")
				.price(550d)
				.length(40d)
				.width(30d)
				.description("Acrylic on canvas. \r\n"
						+ "The tone is predominantly orange and dark blue."
						+ "This canvas is painted yellow around the sides. \r\n"
						+ "It has been given a coat of high gloss varnish to protect and preserve it. r\n"
						+ "Local pick-up only. Delivery within 50 km can be arranged.")
				.collection(Collection.Seascapes)
				.img(product10.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	
	
	@Bean("ProductSea11")
	@Scope("singleton")
	
	public Product ProductSea11() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Dancing waves")
				.price(950d)
				.length(40d)
				.width(50d)
				.description("Acrylic on canvas. \r\n"
						+ "The tone is blue and green."
						+ "This canvas is painted around the sides. \r\n"
						+ "It has been given a coat of high gloss varnish to protect and preserve it. r\n"
						+ "Local pick-up only. Delivery within 50 km can be arranged.")
				.collection(Collection.Seascapes)
				.img(product11.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	
	@Bean("ProductOyster2")
	@Scope("singleton")
	
	public Product ProductOyster2() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Oyster - light blue background")
				.price(250d)
				.length(10d)
				.width(10d)
				.description("Acrylic on canvas.")
				.collection(Collection.Oysters)
				.img(productOyster2.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	
	@Bean("ProductOyster1")
	@Scope("singleton")
	
	public Product ProductOyster1() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Oyster - dark blue background")
				.price(250d)
				.length(10d)
				.width(10d)
				.description("Acrylic on canvas.")
				.collection(Collection.Oysters)
				.img(productOyster1.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	
	
	
	@Bean("ProductFlowers1")
	@Scope("singleton")
	
	public Product ProductFlowers1() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Flower carnival - sunflower & iris")
				.price(1005d)
				.length(60d)
				.width(60d)
				.description("Acrylic on canvas. \r\n"
						+ "This canvas is painted gold around the sides. \r\n"
						+ "It has been given a coat of high gloss varnish to protect and preserve it. r\n"
						+ "Local pick-up only. Delivery within 50 km can be arranged.")
				.collection(Collection.Flowers)
				.img(productFlowers1.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	
	
	@Bean("ProductFlowers2")
	@Scope("singleton")
	
	public Product ProductFlowers2() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Flower carnival - lily & hibiscus")
				.price(1005d)
				.length(60d)
				.width(60d)
				.description("Acrylic on canvas. \r\n"
						+ "This canvas is painted gold around the sides. \r\n"
						+ "It has been given a coat of high gloss varnish to protect and preserve it. r\n"
						+ "Local pick-up only. Delivery within 50 km can be arranged.")
				.collection(Collection.Flowers)
				.img(productFlowers2.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	
	@Bean("ProductCustom1")
	@Scope("singleton")
	
	public Product ProductCustom1() throws IOException {
		
		Client c = clientService.getClientRandom();
	
		boolean isAvailable = setIsAvailable(c);
		
		return Product.builder()
				.title("Commissioned by Daniel")
				.price(0d)
				.length(50d)
				.width(50d)
				.description("Acrylic on canvas.")
				.collection(Collection.Commissioned)
				.img(productCustom1.getImageUrlFromFile())
				.client(c)
				.available(isAvailable)
				.build();
	}
	

	
		}
	

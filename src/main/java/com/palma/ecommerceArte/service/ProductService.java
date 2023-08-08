package com.palma.ecommerceArte.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.palma.ecommerceArte.model.Collection;
import com.palma.ecommerceArte.model.Product;
import com.palma.ecommerceArte.repository.ProductRepository;


import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service 
public class ProductService {

	@Autowired ProductRepository repo;
	@Autowired @Qualifier("ProductSea1") private ObjectProvider <Product> productProvider1;
	@Autowired @Qualifier("ProductSea2") private ObjectProvider <Product> productProvider2;
	@Autowired @Qualifier("ProductSea3") private ObjectProvider <Product> productProvider3;
	@Autowired @Qualifier("ProductSea4") private ObjectProvider <Product> productProvider4;
	@Autowired @Qualifier("ProductSea5") private ObjectProvider <Product> productProvider5;
	@Autowired @Qualifier("ProductSea6") private ObjectProvider <Product> productProvider6;
	@Autowired @Qualifier("ProductSea7") private ObjectProvider <Product> productProvider7;
	@Autowired @Qualifier("ProductSea8") private ObjectProvider <Product> productProvider8;
	@Autowired @Qualifier("ProductSea9") private ObjectProvider <Product> productProvider9;
	@Autowired @Qualifier("ProductSea10") private ObjectProvider <Product> productProvider10;
	@Autowired @Qualifier("ProductSea11") private ObjectProvider <Product> productProvider11;

	
	@Autowired @Qualifier("ProductOyster1") private ObjectProvider <Product> productOyster1;
	@Autowired @Qualifier("ProductOyster2") private ObjectProvider <Product> productOyster2;
	
	@Autowired @Qualifier("ProductFlowers1") private ObjectProvider <Product> productFlowers1;
	@Autowired @Qualifier("ProductFlowers2") private ObjectProvider <Product> productFlowers2;


	@Autowired @Qualifier("ProductCustom1")private ObjectProvider <Product> productCustom1;
	
	public void giveProduct() {		
		
		 createProduct(productProvider2.getObject());
		 createProduct(productProvider7.getObject());
		 createProduct(productProvider4.getObject());
		 createProduct(productProvider5.getObject());
		 createProduct(productProvider10.getObject());
		 createProduct(productProvider1.getObject());
		 createProduct(productProvider3.getObject());
		 createProduct(productProvider11.getObject());
		 createProduct(productProvider9.getObject());
		 createProduct(productProvider8.getObject());
		 createProduct(productProvider6.getObject());
		 
		 
		 createProduct(productOyster1.getObject());
		 createProduct(productOyster2.getObject());

		 
		 createProduct(productFlowers1.getObject());
		 createProduct(productFlowers2.getObject());
		 
		 createProduct(productCustom1.getObject());
		}
	
	//METODI STANDARD PER API
	
	public List<Product> getAllProduct() {
		return (List<Product>) repo.findAll();
	}
	
	public Page<Product> getAllProductPageable(Pageable pageable) {
		return (Page<Product>) repo.findAll(pageable);
	}
	
	
	public Product getProduct(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("La Product con id " + id + " non è presente del database!!!");
		}
		return repo.findById(id).get();
	}
	
	public Product getProductRandom() {
		return repo.findPerProductRandom();
	}
	
	public Product getProductById(Long id) {
		return repo.findById(id).get();
	}
	
	public Product createProduct(Product p) {
		if(p.getId()!=null && repo.existsById(p.getId())) {
			throw new EntityExistsException("This product already exists in the database!");
		} else {
			repo.save(p);
		}		
		return p;
	}
	
	public String removeProduct(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Product with id " + id + "not found!");
		}
		repo.deleteById(id);
		return "Product Deleted!!!";
	}
	
	public Product updateProduct(Product p) {
		if(!repo.existsById(p.getId())) {
			throw new EntityExistsException("Product not found!");
		}
		repo.save(p);
		return p;
	}
	
	//SPECIAL 
	public List<Product> filterByCollection(Collection collection){
		if(!repo.existsByCollection(collection)) {
			throw new EntityExistsException("No paintings available from collection " + collection);
		}
		return  repo.searchByCollection(collection);
	}
}

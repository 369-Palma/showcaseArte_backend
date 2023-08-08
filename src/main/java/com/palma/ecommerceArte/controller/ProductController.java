package com.palma.ecommerceArte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.palma.ecommerceArte.model.Client;
import com.palma.ecommerceArte.model.Collection;
import com.palma.ecommerceArte.model.Product;
import com.palma.ecommerceArte.service.ClientService;
import com.palma.ecommerceArte.service.ProductService;



@CrossOrigin(origins =  "http://localhost:3000", maxAge = 360000)
@Controller
//@CrossOrigin(origins = "http://localhost:3000", maxAge = 360000, allowCredentials = "true")
@RequestMapping("/api/products")
public class ProductController {

	@Autowired ProductService service;
	@Autowired ClientService clientService;
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Product>>(service.getAllProduct(), HttpStatus.OK);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<Product>> getAllPage(Pageable pag) {
		return new ResponseEntity<Page<Product>>(service.getAllProductPageable(pag), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.getProduct(id), HttpStatus.OK);
	}
		
	//@PostMapping
	//@PreAuthorize("hasRole('ADMIN')")
	//public ResponseEntity<?> createProduct(@RequestBody Product p) {
	//	return new ResponseEntity<Product>(service.createProduct(p), HttpStatus.CREATED);
	//}
	
	@PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> createProduct(@RequestParam("title") String title,
                                           @RequestParam("price") double price,
                                           @RequestParam("length") double length,
                                           @RequestParam("width") double width,
                                           @RequestParam("description") String description,
                                           @RequestParam("collection") Collection collection,
                                           @RequestParam("img") MultipartFile img,
                                           @RequestParam("available") boolean available) {
        // Create a Product object and set its properties using the parameters
		
		
        Product p = new Product();
        p.setTitle(title);
        p.setPrice(price);
        p.setLength(length);
        p.setWidth(width);
        p.setDescription(description);
        p.setCollection(collection);
        p.setImg(description);
        p.setAvailable(null);
       

        // Handle the image file and set it in the Product object
        // You might want to save the image to a storage service and store the file path in the Product

        // Call the service to create the product
        Product createdProduct = service.createProduct(p);

        return new ResponseEntity<Product>(createdProduct, HttpStatus.CREATED);
    }
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteProduct(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeProduct(id), HttpStatus.OK);
	}
	
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateUser(@RequestBody Product p) {
		return new ResponseEntity<Product>(service.updateProduct(p), HttpStatus.CREATED);
	}
	
	//SPECIAL
	
	@GetMapping("/collection/{collection}")
	public ResponseEntity<?> filterByCollection(@PathVariable Collection collection){
		return new ResponseEntity <List<Product>>(service.filterByCollection(collection), HttpStatus.OK);
	}
	
}
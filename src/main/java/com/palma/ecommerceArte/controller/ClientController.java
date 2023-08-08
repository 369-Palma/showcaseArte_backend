package com.palma.ecommerceArte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.palma.ecommerceArte.model.Client;
import com.palma.ecommerceArte.service.ClientService;

@CrossOrigin(origins =  "http://localhost:3000", maxAge = 360000)
@Controller
//@CrossOrigin(origins = "http://localhost:3000", maxAge = 360000, allowCredentials = "true")
@RequestMapping("/api/clients")
public class ClientController {

@Autowired ClientService service;
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<Client>>(service.getAllClient(), HttpStatus.OK);
	}


	@GetMapping("/id/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.getClient(id), HttpStatus.OK);
	}
		
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createClient(@RequestBody Client c) {
		return new ResponseEntity<Client>(service.createClient(c), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteClient(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeClient(id), HttpStatus.OK);
	}
	
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateUser(@RequestBody Client c) {
		return new ResponseEntity<Client>(service.updateClient(c), HttpStatus.CREATED);
	}
}

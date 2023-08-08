package com.palma.ecommerceArte.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.palma.ecommerceArte.model.News;
import com.palma.ecommerceArte.service.NewsService;

@CrossOrigin(origins =  "http://localhost:3000", maxAge = 360000)
@Controller

@RequestMapping("/api/news")
public class NewsController {

@Autowired NewsService service;
	
	@GetMapping
	public ResponseEntity<?> getAll() {
		return new ResponseEntity<List<News>>(service.getAllNews(), HttpStatus.OK);
	}

	@GetMapping("/pageable")
	public ResponseEntity<Page<News>> getAllPage(Pageable pag) {
		return new ResponseEntity<Page<News>>(service.getAllNewsPageable(pag), HttpStatus.OK);
	}

	@GetMapping("/id/{id}")
	public ResponseEntity<?> getById(@PathVariable("id") Long id) {
		return new ResponseEntity<>(service.getNews(id), HttpStatus.OK);
	}
		
	@PostMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createNews(@RequestBody News n) {
		return new ResponseEntity<News>(service.createNews(n), HttpStatus.CREATED);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<String> deleteNews(@PathVariable Long id){
		return new ResponseEntity<String>(service.removeNews(id), HttpStatus.OK);
	}
	
	@PutMapping
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> updateUser(@RequestBody News n) {
		return new ResponseEntity<News>(service.updateNews(n), HttpStatus.CREATED);
	}
		
}

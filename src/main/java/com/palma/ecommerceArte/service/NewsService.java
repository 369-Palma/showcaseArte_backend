package com.palma.ecommerceArte.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.palma.ecommerceArte.model.News;
import com.palma.ecommerceArte.repository.NewsRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class NewsService {

	@Autowired NewsRepository repo;
	
	@Autowired @Qualifier("News") private ObjectProvider <News> newsProvider;
	
	public void giveNews() {
		createNews(newsProvider.getObject());
	}

	
	//METODI STANDARD PER API
	
		public List<News> getAllNews() {
			return (List<News>) repo.findAll();
		}
		
		public Page<News> getAllNewsPageable(Pageable pageable) {
			return (Page<News>) repo.findAll(pageable);
		}
		
		
		public News getNews(Long id) {
			if(!repo.existsById(id)) {
				throw new EntityNotFoundException("La News con id " + id + " non è presente del database!!!");
			}
			return repo.findById(id).get();
		}
		
		
		public News getNewsById(Long id) {
			return repo.findById(id).get();
		}
		
		public News createNews(News n) {
			if(n.getId()!=null && repo.existsById(n.getId())) {
				throw new EntityExistsException("This News already exists in the database!");
			} else {
				repo.save(n);
			}		
			return n;
		}
		
		public String removeNews(Long id) {
			if(!repo.existsById(id)) {
				throw new EntityExistsException("News with id " + id + "not found!");
			}
			repo.deleteById(id);
			return "News Deleted!!!";
		}
		
		public News updateNews(News n) {
			if(!repo.existsById(n.getId())) {
				throw new EntityExistsException("News not found!");
			}
			repo.save(n);
			return n;
		}
}

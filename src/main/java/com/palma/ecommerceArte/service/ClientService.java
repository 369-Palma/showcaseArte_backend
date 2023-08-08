package com.palma.ecommerceArte.service;

import java.util.List;

import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.palma.ecommerceArte.model.Client;
import com.palma.ecommerceArte.repository.ClientRepository;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;

@Service
public class ClientService {

	@Autowired ClientRepository repo;
	@Autowired @Qualifier("clientRandom") private ObjectProvider <Client> clientProvider;
	
	public void createClientRandom() {		
		 createClient(clientProvider.getObject());
		}
	
	//METODI STANDARD PER API
	
	public List<Client> getAllClient() {
		return (List<Client>) repo.findAll();
	}
	
	public Client getClient(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityNotFoundException("Client with id" + id + "not found!");
		}
		return repo.findById(id).get();
	}
	
	public Client getClientRandom() {
		return repo.findPerClientRandom();
	}
	
	public Client getClientById(Long id) {
		return repo.findById(id).get();
	}
	
	public Client createClient(Client c) {
		if(c.getId()!=null && repo.existsById(c.getId())) {
			throw new EntityExistsException("This Client already exists in the database!");
		} else {
			repo.save(c);
		}		
		return c;
	}
	
	public String removeClient(Long id) {
		if(!repo.existsById(id)) {
			throw new EntityExistsException("Client with id " + id + "not found!");
		}
		repo.deleteById(id);
		return "Client Deleted!!!";
	}
	
	public Client updateClient(Client c) {
		if(!repo.existsById(c.getId())) {
			throw new EntityExistsException("Client not found!");
		}
		repo.save(c);
		return c;
	}
	
}

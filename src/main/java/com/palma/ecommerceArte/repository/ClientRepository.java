package com.palma.ecommerceArte.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.palma.ecommerceArte.model.Client;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {

	@Query(value="SELECT c FROM Client c ORDER BY RANDOM() LIMIT 1")
	Client findPerClientRandom();
}

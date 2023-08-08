package com.palma.ecommerceArte.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.palma.ecommerceArte.model.Collection;
import com.palma.ecommerceArte.model.Product;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

	public boolean existsByCollection(Collection collection);
	
	@Query("SELECT p FROM Product p WHERE p.collection = :collection")
	public List<Product> searchByCollection(@Param("collection") Collection collection);

	@Query(value="SELECT p FROM Product p ORDER BY RANDOM() LIMIT 1")
	Product findPerProductRandom();

}

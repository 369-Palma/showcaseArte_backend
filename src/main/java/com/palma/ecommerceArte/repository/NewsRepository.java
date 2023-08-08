package com.palma.ecommerceArte.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.palma.ecommerceArte.model.News;

@Repository
public interface NewsRepository extends JpaRepository<News, Long> {

}

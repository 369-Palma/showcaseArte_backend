package com.palma.ecommerceArte.configuration;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import com.palma.ecommerceArte.model.News;


@Configuration
public class NewsConfiguration {
	@Lazy
	@Autowired News news;
	
		@Bean("News")
		@Scope("singleton")
		
		public News news() throws IOException {
			LocalDate localDate = LocalDate.of(2024, 5, 16);
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy").withLocale(Locale.ITALY);
			//System.out.println(localDate.format(formatter));
			String dove = "Bari";
			LocalDate publication = LocalDate.now();
			
			return News.builder()
					.title("Esposizione")
					.dove("Bari")
					.quando(localDate)
					.description("I'm thrilled to invite you to my next exhibition! \r\n " + " When: " + localDate.format(formatter) +
					"\r\n Where: " + dove )
					//.description("On " + news.getQuando() + " in " + news.getDove() + " there will be my next esposition. Save the date!")
					.publicationDate(publication)
					.build();
		}
		
	}



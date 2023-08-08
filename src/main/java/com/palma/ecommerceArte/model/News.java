package com.palma.ecommerceArte.model;

import java.time.LocalDate;


import jakarta.persistence.*;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
public class News {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
		private String title;
@Column(nullable = false)
		private String dove;
@Column(nullable = false)
		private LocalDate quando;
@Column(nullable = false, columnDefinition = "TEXT")
		private String description;

@Column(nullable = false)
	private LocalDate publicationDate;
	}



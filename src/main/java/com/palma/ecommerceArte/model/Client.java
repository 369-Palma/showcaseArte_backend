package com.palma.ecommerceArte.model;

import java.util.List;

import com.palma.ecommerceArte.auth.entity.User;

import jakarta.persistence.*;
import lombok.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name="clients")
public class Client {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private String name;
@Column(nullable = false)
private String lastname;
@Column(nullable = false)
private String number;
@Column(nullable = false)
private String email;

@OneToMany(mappedBy = "client", cascade = CascadeType.MERGE)
private List<Product> products;
@OneToOne
@JoinColumn(name = "user_id")
private User user;
}


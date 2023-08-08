package com.palma.ecommerceArte.model;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

@Entity
@Table(name="products")
public class Product {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(nullable = false)
private String title;
@Column(nullable = false)
private Double price;
@Column(nullable = false)
private Double length;
@Column(nullable = false)
private Double width;
@Column(nullable = false, columnDefinition = "TEXT")
private String description;

@Enumerated(EnumType.STRING)
@Column(nullable = false)
private Collection collection;
@Column(nullable = false, columnDefinition = "TEXT")
private String img;

//@JsonIgnore
@JoinColumn(name = "client_id")
@OneToOne(cascade = CascadeType.MERGE)
private Client client;

@Column(nullable = true)
@Builder.Default
private Boolean available = true;


//GETTER $ SETTER

public Long getId() {
	return id;
}

public String getTitle() {
	return title;
}


public void setTitle(String title) {
	this.title = title;
}


public Double getPrice() {
	return price;
}

public void setPrice(Double price) {
	this.price = price;
}


public Double getLength() {
	return length;
}


public void setLength(Double length) {
	this.length = length;
}


public Double getWidth() {
	return width;
}


public void setWidth(Double width) {
	this.width = width;
}


public String getDescription() {
	return description;
}


public void setDescription(String description) {
	this.description = description;
}


public String getImg() {
	return img;
}


public void setImg(String img) {
	this.img = img;
}


public Boolean getAvailable() {
    return available;
}

public void setAvailable(Boolean available) {
    this.available = available;
}

public Client getClient() {
    return client;
}

public void setClient(Client client) {
    this.client = client;
}

public void updateAvailability() {
    this.available = (client == null);
}


public Collection getCollection() {
    return collection;
}

public void setCollection(Collection collection) {
    this.collection = collection;
}

}

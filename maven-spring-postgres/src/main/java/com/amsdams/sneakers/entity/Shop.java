package com.amsdams.sneakers.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Shop {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long id;

	private String name;
	private String url;
	@OneToMany(targetEntity = Product.class, fetch = FetchType.EAGER)
	private List<Product> products;

	public Shop(String name, String url, List<Product> products) {
		super();
		this.name = name;
		this.url = url;
		this.products = products;
	}

}
package com.amsdams.sneakers.entity;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Long id;
	private String name;
	@ManyToMany(targetEntity = Brand.class, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Brand> brands;
	private BigDecimal priceNew;
	private BigDecimal priceOld;
	private String url;
	@ManyToMany(targetEntity = Size.class, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Size> sizes;

	public Product(String name, List<Brand> brands, BigDecimal priceNew, BigDecimal priceOld, String url,
			List<Size> sizes) {
		super();
		this.name = name;
		this.brands = brands;
		this.priceNew = priceNew;
		this.priceOld = priceOld;
		this.url = url;
		this.sizes = sizes;

	}

}
package com.amsdams.sneakers.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Size {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String size;

	public Size(String size) {
		super();
		this.size = size;
	}
}
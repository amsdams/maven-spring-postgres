package com.amsdams.sneakers.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.amsdams.sneakers.entity.Brand;

public interface BrandRepo extends PagingAndSortingRepository<Brand, String> {
	Page<Brand> findByName(@Param("name") String name, Pageable pageable);

}
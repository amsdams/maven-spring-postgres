package com.amsdams.sneakers.repo;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.amsdams.sneakers.entity.Brand;
import com.amsdams.sneakers.entity.Product;
import com.amsdams.sneakers.entity.Size;

public interface ProductRepo extends PagingAndSortingRepository<Product, String> {
	Page<Product> findByBrandsIn(@Param("brands") List<Brand> brands, Pageable pageable);
	// List<Question> findByTagsIn(List<String> tags);

	Page<Product> findBySizesIn(@Param("sizes") List<Size> sizes, Pageable pageable);

	Page<Product> findByName(@Param("name") String name, Pageable pageable);
}
package com.amsdams.sneakers.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.amsdams.sneakers.entity.Size;

public interface SizeRepo extends PagingAndSortingRepository<Size, String> {
	Page<Size> findBySize(@Param("size") String name, Pageable pageable);

}
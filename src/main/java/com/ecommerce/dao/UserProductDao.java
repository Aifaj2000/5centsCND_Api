package com.ecommerce.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.UserProduct;

@Repository
public interface UserProductDao extends CrudRepository<UserProduct, Integer> {
//    public List<Product> findAll(Pageable pageable);
//
//    public List<Product> findByProductNameContainingIgnoreCaseOrProductDescriptionContainingIgnoreCase(
//            String key1, String key2, Pageable pageable
//    );

	
}

package com.infosys.ecart.ProductMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infosys.ecart.ProductMS.entity.Product;

public interface ProductRepository extends CrudRepository<Product,Integer>{
	
	@Query("select P from Product P where P.category = :category")
	public List<Product> findByCategory(@Param("category") String category);
	@Query("select P from Product P where P.productName = :productName")
	public List<Product> findByProductName(@Param("productName")String productName);
	@Query("select P from Product P where P.sellerId = :sellerId")
	public List<Product> findBySellerId(@Param("sellerId")String sellerId);
	
}

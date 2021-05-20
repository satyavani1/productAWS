package com.infosys.ecart.ProductMS.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.infosys.ecart.ProductMS.entity.CompositeIDclass;
import com.infosys.ecart.ProductMS.entity.SubscribedProduct;

public interface SubscribedProductRepository extends CrudRepository<SubscribedProduct,CompositeIDclass>{
	
	@Query("select S from SubscribedProduct S where S.prodId = :prodId")
	public SubscribedProduct findByProdId(@Param("prodId")Integer prodId);
	@Query("select S from SubscribedProduct S where S.buyerId = :buyerId")
	public List<SubscribedProduct> findByBuyerId(@Param("buyerId")String buyerId);
}

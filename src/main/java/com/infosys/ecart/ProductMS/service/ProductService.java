package com.infosys.ecart.ProductMS.service;

import java.util.List;

import com.infosys.ecart.ProductMS.dto.ProductDTO;
import com.infosys.ecart.ProductMS.dto.SubscribedProuctDTO;
import com.infosys.ecart.ProductMS.exception.ProductMSException;

public interface ProductService {

	//common methods for normal buyers and visitors
	List<ProductDTO> viewProducts() throws ProductMSException;
	List<ProductDTO> searchProductsByCategory(String category) throws ProductMSException;
	List<ProductDTO> searchProductsByProductName(String productName) throws ProductMSException;
	
	//extra methods for privileged buyers
	String addProductToSubscribedlist(SubscribedProuctDTO subscribedProductDTO) throws ProductMSException;
	String removeProductFromSubscribedlist(Integer prodId) throws ProductMSException;
	List<SubscribedProuctDTO> viewSubscribedlist(String buyerId) throws ProductMSException;
	
	//methods handled by seller
	Integer addProduct(ProductDTO productDTO) throws ProductMSException;
	String removeProduct(Integer prodId) throws ProductMSException;
	ProductDTO viewProductByProdId(Integer prodId) throws ProductMSException;
	List<ProductDTO> viewProductsBySellerId(String sellerId) throws ProductMSException;
	String addStockToProducts(ProductDTO productDTO,Integer quantity) throws ProductMSException;
	
	//for ordering a product
	List<Float> getPriceAndStock(Integer prodId) throws ProductMSException;
	void updateStockAfterOrder(ProductDTO productDTO) throws ProductMSException;
}

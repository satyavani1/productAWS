package com.infosys.ecart.ProductMS.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.infosys.ecart.ProductMS.dto.ProductDTO;
import com.infosys.ecart.ProductMS.dto.SubscribedProuctDTO;
import com.infosys.ecart.ProductMS.exception.ProductMSException;
import com.infosys.ecart.ProductMS.service.ProductService;

@CrossOrigin
@RestController
@Valid
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@Autowired
	Environment environment;
	
	//fetches all products 
	@GetMapping("/viewAllProducts")
	public List<ProductDTO> viewAllProducts()  throws ProductMSException{
		return productService.viewProducts();
	}
	
	//fetches products based on their category
	@GetMapping("/viewProducts/category/{category}")
	public List<ProductDTO> viewProductsByCategory(@PathVariable String category) throws ProductMSException{
		return productService.searchProductsByCategory(category);
	}
	
	//fetches products based on their productName
	@GetMapping("/viewProducts/productname/{productName}")
	public List<ProductDTO> viewProductsByProductName(@PathVariable String productName) throws ProductMSException{
		return productService.searchProductsByProductName(productName);
	}
	
	//fecthes a particular product
	@GetMapping("/viewProduct/{productId}")
	public String checkProductByProdId(@PathVariable Integer productId) throws ProductMSException{
		productService.viewProductByProdId(productId);
		return "The Product exists in the list";
	}
	
	//adding a product to subscription list
	@PostMapping("/subscription/add/")
	public String addToSubscriptionlist(@RequestBody SubscribedProuctDTO subscribedProductDTO)  throws ProductMSException{
//		//this method uses the endpoints of Order to place order
//		String uri = "http://localhost:8200/order";
//		RestTemplate rest = new RestTemplate();
//		Integer orderId = rest.postForObject(uri, subscribedProductDTO, Integer.class);
		return productService.addProductToSubscribedlist(subscribedProductDTO);
	}
	
	//removing a product from subscription list
	@DeleteMapping("/subscription/remove/{prodId}")
	public String removeFromSubscriptionlist(@PathVariable Integer prodId) throws ProductMSException {
		return productService.removeProductFromSubscribedlist(prodId);
	}
	
	@GetMapping("/subscription/view/{buyerId}")
	public List<SubscribedProuctDTO> viewSubscriptionlist(@PathVariable String buyerId)  throws ProductMSException{
		return productService.viewSubscribedlist(buyerId);
	}
	
	
	
	//-------------------seller methods----------------------
	
	//fetches all products under his id
	@GetMapping("/seller/viewProducts/{sellerId}")
	public List<ProductDTO> viewSellerProducts(@PathVariable String sellerId) throws ProductMSException {
		return productService.viewProductsBySellerId(sellerId);
	}
	
	//fecthes a particular product
	@GetMapping("/seller/viewProduct/{prodId}")
	public ProductDTO viewProductByProdId(@PathVariable Integer prodId) throws ProductMSException{
		return productService.viewProductByProdId(prodId);
	}
	
	//adding a new product by seller
	@PostMapping("/seller/addProduct")
	public ResponseEntity<String> addProduct(@Valid @RequestBody ProductDTO productDTO)  throws ProductMSException{
			String msg = "Your product is added with product ID : "+productService.addProduct(productDTO);
			return new ResponseEntity<>(msg,HttpStatus.OK);
	}
	
	//removing an existing product by seller
	@DeleteMapping("/seller/removeProduct/{prodId}")
	public String removeProduct(@PathVariable Integer prodId) throws ProductMSException {
		return productService.removeProduct(prodId);
	}
	
	//adding more stocks to an existing product
	@PutMapping("/seller/addStock/{quantity}")
	public String addStockToProduct(@RequestBody ProductDTO productDTO,@PathVariable Integer quantity) throws ProductMSException {
		return productService.addStockToProducts(productDTO, quantity);
	}
	
	
	
	/* Order */
	@GetMapping("/viewProducts/priceAndStock/{prodId}")
	public List<Float> getPriceAndStockForAProduct(@PathVariable Integer prodId) throws ProductMSException {
		return productService.getPriceAndStock(prodId);
	}
	
	//updating the stock after accepting a order
	@PutMapping("/updateStock")
	public void updateStockAFterOrder(@RequestBody ProductDTO productDTO)  throws ProductMSException{
		productService.updateStockAfterOrder(productDTO);
	}
		
}

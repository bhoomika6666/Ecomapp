package com.sdp.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sdp.ecommerce.entity.Product;
import com.sdp.ecommerce.repository.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	
	//save
	public Product saveProduct(Product product) {
		product.setId(null);
		return productRepository.save(product);
	}
	
	//get by id
	public Product getProductById(String id) {
		return productRepository.findById(id).get();
	}
	
	//get all products
	public List<Product> getProduct(){
		return productRepository.findAll();
	}
	
	//delete product
	public boolean deleteProduct(String id) {
		Optional<Product> product = productRepository.findById(id);
		if(product.isEmpty()) {
			return false;
		}
		productRepository.deleteById(id);
		return true;
	}
	
	//update product
	public Product updateProduct(Product product, String id) {
		Product existingProduct = productRepository.findById(id).get();
		
		existingProduct.setName(product.getName());
		existingProduct.setDescription(product.getDescription());
		existingProduct.setCategory(product.getCategory());
		existingProduct.setPrice(product.getPrice());
		existingProduct.setTags(product.getTags());
		existingProduct.setStock(product.getStock());
		
		return productRepository.save(existingProduct);
		
	}
	

}

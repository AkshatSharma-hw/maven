package com.zensar.services;
/**
 * @author Chetna Khapre
 * @version 1.0
 * @Creation_date 01/10/2019 10:36am
 * @modification date 04/10/2019 10:36am
 *@Description This is used in business layer.
 */

import java.util.List;

import com.zensar.entities.Product;

public interface ProductService {
	List<Product> findAllProducts();
	Product findById(int ProductId);
	void insertProduct(Product product);
	void updateProduct(Product product);
	void removeProduct(Product product);
	
	List<Product> findProductsByPriceRange(float max, float min);
	List<Product> findProductByName(String name);
	List<Product> findProductByBrand(String brand);
	
	long getProductCount();
	
	
}

package com.zensar.daos;

import java.util.List;

import com.zensar.entities.Product;

/**
 * @author CK
 * @version 1.0
 * @Creation date 04/10/2019 10:07am
 * @Modification date 04/10/2019 10:07am
 * @Description It is product dao interface
 */
public interface ProductDao {
	List<Product> getAll();
	
	Product getById(int ProductId);
	
	void insert(Product product);
	
	void update(Product product);
	
	void delete(Product product);
}

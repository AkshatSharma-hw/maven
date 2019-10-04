package com.zensar.services;
import java.util.ArrayList;
/**
 * @author CK
 * @version 1.0
 * @Creation date 04/10/2019 10:07am
 * @Modification date 04/10/2019 10:07am
 */
import java.util.List;

import com.zensar.daos.ProductDao;
import com.zensar.daos.ProductDaoImpl;
import com.zensar.entities.Product;

public class ProductServiceImpl implements ProductService {
	private ProductDao productDao;
	
	public ProductServiceImpl() {
		productDao = new ProductDaoImpl();
	}
	
	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return productDao.getAll();
	}

	@Override
	public Product findById(int ProductId) {
		// TODO Auto-generated method stub
		return productDao.getById(ProductId);
	}

	@Override
	public void insertProduct(Product product) {
		// TODO Auto-generated method stub
		productDao.insert(product);

	}

	@Override
	public void updateProduct(Product product) {
		productDao.update(product);
		// TODO Auto-generated method stub

	}

	@Override
	public void removeProduct(Product product) {
		
		productDao.delete(product);
		// TODO Auto-generated method stub

	}

	@Override
	public List<Product> findProductsByPriceRange(float max, float min) {
		List<Product> all = productDao.getAll();
		List<Product> priceSorted = new ArrayList<Product>();
		for (Product product : all) {
			float price = product.getPrice();
			if(price >= min && price <= max) {
				priceSorted.add(product);
			}
		}
		return (priceSorted) ;
	}

	@Override
	public List<Product> findProductByName(String name) {
		List<Product> all = productDao.getAll();
		List<Product> productByName = new ArrayList<>();
		for (Product product : all) {
			if((product.getName()).equals(name)) {
				productByName.add(product);
			}
		}
		
		return productByName;
	}

	@Override
	public List<Product> findProductByBrand(String brand) {
		List<Product> all = productDao.getAll();
		List<Product> productByBrand = new ArrayList<>();
		for (Product product : all) {
			if((product.getBrand()).equals(brand)) {
				productByBrand.add(product);
			}
		}
		
		return productByBrand;
		
	}

	@Override
	public long getProductCount() {
		List<Product> allProducts = productDao.getAll();
		long count =  allProducts.size();
		return count;
	}

}

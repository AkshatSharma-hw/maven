package com.zensar.daos;

/**
 * @author Chetna Khapre
 * @version 2.0
 * @Creation_date 01/10/2019 10:10am
 * @modification date 04/10/2019 10:04am
 *
 */
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.zensar.entities.Product;

public class ProductDaoImpl implements ProductDao {
	private Session s;
	public ProductDaoImpl() {
	
		Configuration c = new Configuration().configure();
		SessionFactory f = c.buildSessionFactory();
		s = f.openSession();
		
		
		
	}
	
	
	@Override
	public List<Product> getAll() {
		
		return (s.createQuery("from Product").getResultList());
	}

	@Override
	public Product getById(int ProductId) {
		
		return (s.get(Product.class, ProductId));
	}

	@Override
	public void insert(Product product) {
		s.save(product);

	}

	@Override
	public void update(Product product) {
		s.update(product);
		
	}

	@Override
	public void delete(Product product) {
		s.delete(product);

	}

}

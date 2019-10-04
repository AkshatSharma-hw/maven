package com.zensar.restfull;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.zensar.entities.Product;
import com.zensar.services.ProductService;
import com.zensar.services.ProductServiceImpl;

/**
 * @author CK
 * @version 1.0
 * @Creation date 04/10/2019 02:00pm
 * @Modification date 04/10/2019 02:00pm
 */

@Path("/products")
public class ProductWebService {
	private ProductService productService;
	
	public ProductWebService() {
		productService = new ProductServiceImpl();
		
	}
	
	@GET
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Product> getAllProducts(){
		return productService.findAllProducts();
		
	}
	
	
	
}

package com.zensar.restfull;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
	
	@GET
	@Path("/{id}")
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public Product getProduct(@PathParam("id") int productId) {
		return productService.findById(productId);
	}
	
	@GET
	@Path("/count")
	@Produces("text/html")
	public Response getProductCount() {
		long count = productService.getProductCount();
		return Response.status(200).entity("No. of products : "+ count).build();
	}
	
	@POST
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces("text/html")
	public Response add(Product product) {
		productService.insertProduct(product);
		return Response.status(200).entity(product.getProductId() + " is added successful").build();
	}
	
	@PUT
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces("text/html")
	public Response update(Product product) {
		Product dbProduct = productService.findById(product.getProductId());
		if(dbProduct != null) {
			dbProduct.setName(product.getName());;
			dbProduct.setBrand(product.getBrand());
			dbProduct.setPrice(product.getPrice());
			productService.updateProduct(dbProduct);
			return Response.status(200).entity("product "+dbProduct.getProductId()+" updated successfully").build();
			
		}
		else {
			return Response.status(200).entity("product not found").build();
		}
		
		
	}
	
	@DELETE
	@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	@Produces("text/html")
	public Response delete(Product product) {
		Product dbProduct = productService.findById(product.getProductId());
		if(dbProduct != null) {
			
			productService.removeProduct(dbProduct);
			return Response.status(200).entity("product "+dbProduct.getProductId()+" deleted successfully").build();
			
		}
		else {
			return Response.status(200).entity("product not found").build();
		}
	}
	@POST
	@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
	public List<Product> getByPriceRange(@FormParam("max") float maxprice, @FormParam("min") float minprice){
		
		return productService.findProductsByPriceRange(maxprice, minprice);
	}
}

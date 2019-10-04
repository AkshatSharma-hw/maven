package com.zensar.entities;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
/**
 * @author Chetna Khapre
 * @version 2.0
 * @Creation_date 01/10/2019 10:10am
 * @modification date 04/10/2019 10:04am
 *
 */

@XmlRootElement
@Entity
public class Product {
	@Id
	@Column(name = "Id")
	private int productId;
	private String name;
	private String brand;
	private float price;
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", brand=" + brand + ", price=" + price + "]";
	}
	
	
}

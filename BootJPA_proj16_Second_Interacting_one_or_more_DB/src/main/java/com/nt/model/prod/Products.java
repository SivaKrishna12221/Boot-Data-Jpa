package com.nt.model.prod;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="jpa_cdb_products2")
public class Products 
{
	@Override
	public String toString() {
		return "Products [pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + "]";
	}
	public Products() {
		super();
	}
	public Products(String pname, double price, Integer quantity) {
		super();
		this.pname = pname;
		this.price = price;
		this.quantity = quantity;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
 private Integer pid;
 private String pname;
 private double price;
 private Integer quantity;
}

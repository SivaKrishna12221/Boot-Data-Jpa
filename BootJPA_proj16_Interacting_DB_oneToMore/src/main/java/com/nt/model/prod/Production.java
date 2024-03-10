package com.nt.model.prod;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mds_products")
public class Production
{
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Integer pid;
  public Production() {
	super();
}
public Production(String pname, Double price, Integer quantity) {
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
public Double getPrice() {
	return price;
}
public void setPrice(Double price) {
	this.price = price;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "Production [pid=" + pid + ", pname=" + pname + ", price=" + price + ", quantity=" + quantity + "]";
}
private String  pname;
  private Double price;
  private Integer quantity;
}

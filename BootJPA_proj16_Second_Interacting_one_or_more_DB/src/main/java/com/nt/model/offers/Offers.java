package com.nt.model.offers;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="jpa_cdb_Offers2")
public class Offers 
{
	 @Id
	 // @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer offerId;
 private String offerName;
 private String offerCode;
 private Double discount;
 public Offers() {
	super();
}
public Offers(Integer offerId,String offerName, String offerCode, Double discount, LocalDateTime ldt) {
	super();
	this.offerId=offerId;
	this.offerName = offerName;
	this.offerCode = offerCode;
	this.discount = discount;
	this.ldt = ldt;
}
@Override
public String toString() {
	return "Offers [offerId=" + offerId + ", offerName=" + offerName + ", offerCode=" + offerCode + ", discount="
			+ discount + ", ldt=" + ldt + "]";
}
public String getOfferName() {
	return offerName;
}
public void setOfferName(String offerName) {
	this.offerName = offerName;
}
public String getOfferCode() {
	return offerCode;
}
public void setOfferCode(String offerCode) {
	this.offerCode = offerCode;
}
public Double getDiscount() {
	return discount;
}
public void setDiscount(Double discount) {
	this.discount = discount;
}
public LocalDateTime getLdt() {
	return ldt;
}
public void setLdt(LocalDateTime ldt) {
	this.ldt = ldt;
}
private LocalDateTime ldt;
}

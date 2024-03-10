package com.nt.model.promotion;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mds_promotion")
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer offerId;

	public Promotion() {
		super();
	}

	@Override
	public String toString() {
		return "Promotion [offerId=" + offerId + ", offerName=" + offerName + ", offerCode=" + offerCode
				+ ", discountPercentage=" + discountPercentage + ", expireDate=" + expireDate + "]";
	}

	public Integer getOfferId() {
		return offerId;
	}

	public void setOfferId(Integer offerId) {
		this.offerId = offerId;
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

	public Double getDiscountPercentage() {
		return discountPercentage;
	}

	public void setDiscountPercentage(Double discountPercentage) {
		this.discountPercentage = discountPercentage;
	}

	public LocalDateTime getExpireDate() {
		return expireDate;
	}

	public void setExpireDate(LocalDateTime expireDate) {
		this.expireDate = expireDate;
	}

	public Promotion(String offerName, String offerCode, Double discountPercentage, LocalDateTime expireDate) {
		super();
		this.offerName = offerName;
		this.offerCode = offerCode;
		this.discountPercentage = discountPercentage;
		this.expireDate = expireDate;
	}

	private String offerName;
	private String offerCode;
	private Double discountPercentage;
	private LocalDateTime expireDate;
}

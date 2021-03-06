package com.prs.business;

import javax.persistence.*;

@Entity
public class PurchaseRequestLineItem {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "purchaseRequestID")
	PurchaseRequest purchaseRequest;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "productID")
	Product product;
	int quantity;
	
	
	
	public PurchaseRequestLineItem() {
		
	}



	public PurchaseRequestLineItem(int id, PurchaseRequest purchaseRequest, Product product, int quantity) {
		super();
		this.id = id;
		this.purchaseRequest = purchaseRequest;
		this.product = product;
		this.quantity = quantity;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public PurchaseRequest getPurchaseRequest() {
		return purchaseRequest;
	}



	public void setPurchaseRequest(PurchaseRequest purchaseRequest) {
		this.purchaseRequest = purchaseRequest;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	@Override
	public String toString() {
		return "PurchaseRequestLineItem [id=" + id + ", purchaseRequest=" + purchaseRequest + ", product=" + product
				+ ", quantity=" + quantity + "]";
	}
	
	

}

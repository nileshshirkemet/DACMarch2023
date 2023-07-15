package com.met.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity(name = "orders")
public class CustomerOrder {

	@Id
	@Column(name = "ord_no")
	private int orderNo;
	
	@Column(name = "cust_id")
	private String custId;
	
	@Column(name = "pno")
	private int productNo;
	
	@Column(name = "qty")
	private int quantity;
	
//	@Temporal(TemporalType.DATE) for java.util.Date
	@Column(name = "ord_date")
	private Date orderDate;

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getCustId() {
		return custId;
	}

	public void setCustId(String custId) {
		this.custId = custId;
	}

	public int getProductNo() {
		return productNo;
	}

	public void setProductNo(int productNo) {
		this.productNo = productNo;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	
	
	
}
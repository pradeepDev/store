package com.hadware.store.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "buyer")
public class Buyer implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@javax.persistence.Id
	@Column(name = "ID", unique = true)
    private int Id;
	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "Bill_No",unique = true)
	private int billNo;
	
	@Column(name = "Buyer_Name")
	private String buyerName;
	
	@Column(name = "Selling_Date")
	private Date sellingDate;	
	
	@Column(name = "Buyer_GSTIN_Number")
	private String gstinNumber;
	
	@Column(name = "Eway_Bill_Number")
	private String ewayBillNumber;
	
	@OneToMany(mappedBy = "BuyerId", cascade = {CascadeType.ALL})
	private List<Cart> cartList;

}

package com.hadware.store.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "cart")
public class Cart implements Serializable {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@javax.persistence.Id
	@Column(name = "ID", unique = true)
    private int Id;
	
	@Column(name = "item_Serial_no",unique = true)
  	private Long itemSerialno;
	
	@Column(name = "item_Name")
	private String itemName;
	
	@Column(name = "rate")
	private double rate;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "amount")
	private double amount;
	

	@JoinColumn(name = "Buyer_id", referencedColumnName = "Bill_No")
	private int BuyerId;
}

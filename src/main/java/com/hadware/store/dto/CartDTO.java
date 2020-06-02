package com.hadware.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CartDTO {

	private Long itemSerialno;
	private String itemName;
	private double rate;
	private int quantity;
	private double amount;
	private int BuyerId;
	
}

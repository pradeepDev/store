package com.hadware.store.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class BuyerDTO implements Serializable {
	private int billNo;
	private Date sellingDate;
	private String buyerName;
	private String gstinName;
	private String ewayBillNumber;
	private List<CartDTO> cartList;
}

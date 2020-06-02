package com.hadware.store.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class BuyerDTOExt extends BuyerDTO{
	
	@JsonIgnore
	private List<CartDTO> cartList;

}

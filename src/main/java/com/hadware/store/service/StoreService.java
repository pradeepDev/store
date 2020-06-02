package com.hadware.store.service;

import java.util.Date;
import java.util.List;

import com.hadware.store.dto.BuyerDTO;
import com.hadware.store.dto.CartDTO;
public interface StoreService {

	public Double calculate(List<CartDTO> cartDTO);
	public List<CartDTO> getCartDetials();
	public List<BuyerDTO> getBuyerDetails();
	public BuyerDTO  saveandGenerate(BuyerDTO buyerDTO);
	public List<BuyerDTO> getBuyerDetailsByName(String name);
	public List<BuyerDTO> getBuyerDetailsByDate(Date SellingDate);
	public int getMaxBill_No();
}

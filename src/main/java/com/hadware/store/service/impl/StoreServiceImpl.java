package com.hadware.store.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hadware.store.dao.BuyerRepository;
import com.hadware.store.dao.CartRepository;
import com.hadware.store.dto.BuyerDTO;
import com.hadware.store.dto.CartDTO;
import com.hadware.store.mapper.BuyerMapper;
import com.hadware.store.model.Buyer;
import com.hadware.store.model.Cart;
import com.hadware.store.service.StoreService;

@Service

public class StoreServiceImpl implements StoreService {

	private static final Logger logger = LoggerFactory.getLogger(StoreServiceImpl.class);

	@Autowired
	protected BuyerRepository buyerRepository;

	@Autowired
	protected CartRepository cartRepository;

	@Autowired
	protected BuyerMapper buyerMapper;

	public Double calculate(List<CartDTO> cartDTOlist) {
		List<Double> costPerItem = new ArrayList<Double>();
		Double CostFotTotalItem = 0.00;

		for (CartDTO CostForEach : cartDTOlist) {
			if (CostForEach.getItemSerialno() != null) {
				costPerItem.add(CostForEach.getRate() * CostForEach.getQuantity());
				CostForEach.setAmount(CostForEach.getRate() * CostForEach.getQuantity());
			}
		}
		if (costPerItem != null) {
			for (Double item : costPerItem) {
				CostFotTotalItem += item;
			}
		}
		return CostFotTotalItem;
	}

	public List<CartDTO> getCartDetials() {
		List<CartDTO> cartDTOs = new ArrayList();
		CartDTO cartDTO = new CartDTO();
		cartDTO.setItemSerialno(1L);
		cartDTO.setItemName("raju");
		cartDTO.setRate(10.00);
		cartDTO.setQuantity(1);
		cartDTO.setAmount(100.00);
		CartDTO cartDTO1 = new CartDTO();
		cartDTO1.setItemSerialno(1L);
		cartDTO1.setItemName("raju");
		cartDTO1.setRate(10.00);
		cartDTO1.setQuantity(1);
		cartDTO1.setAmount(100.00);
		cartDTOs.add(cartDTO1);
		cartDTOs.add(cartDTO);
		return cartDTOs;

	}

	public List<BuyerDTO> getBuyerDetails() {

		// List<Cart> cartList= cartRepository.findAll();
		List<Buyer> buyerList = buyerRepository.findAll();
		for (Buyer buyer : buyerList) {
			List<Cart> cartList = cartRepository.getCartDetials(buyer.getBillNo());
			if (cartList != null && !cartList.isEmpty()) {
				buyer.setCartList(cartList);
			}
		}
		List<BuyerDTO> buyerDTOList = buyerMapper.map(buyerList);
		return buyerDTOList;
	}

	public List<BuyerDTO> getBuyerDetailsByName(String name) {

		List<Buyer> buyerList = buyerRepository.getBuyerListByName(name);
		for (Buyer buyer : buyerList) {
			List<Cart> cartList = cartRepository.getCartDetials(buyer.getBillNo());
			if (cartList != null && !cartList.isEmpty()) {
				buyer.setCartList(cartList);
			}
		}
		List<BuyerDTO> buyerDTOList = buyerMapper.map(buyerList);
		return buyerDTOList;
	}

	public List<BuyerDTO> getBuyerDetailsByDate(Date SellingDate) {

		List<Buyer> buyerList = buyerRepository.getBuyerListByDate(SellingDate);
		for (Buyer buyer : buyerList) {
			List<Cart> cartList = cartRepository.getCartDetials(buyer.getBillNo());
			if (cartList != null && !cartList.isEmpty()) {
				buyer.setCartList(cartList);
			}
		}
		List<BuyerDTO> buyerDTOList = buyerMapper.map(buyerList);
		return buyerDTOList;
	}

	public int getMaxBill_No() {
		return buyerRepository.getMaxBill_No();
	}

	public BuyerDTO saveandGenerate(BuyerDTO buyerdto) {
		BuyerDTO savedbuyerDTO = new BuyerDTO();
		if (buyerdto != null) {

			Buyer buyer = buyerMapper.map(buyerdto);
			buyer = buyerRepository.save(buyer);
			if (buyer != null) {
				savedbuyerDTO = buyerMapper.map(buyer);
			}
		}
		return savedbuyerDTO;
	}

}

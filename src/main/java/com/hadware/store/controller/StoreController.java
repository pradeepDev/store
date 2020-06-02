package com.hadware.store.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hadware.store.dto.BuyerDTO;
import com.hadware.store.dto.CartDTO;
import com.hadware.store.service.StoreService;

@RestController
@RequestMapping(value = "/api/store", produces = MediaType.APPLICATION_JSON_VALUE)
public class StoreController {

	private static final Logger LOGGER = LoggerFactory.getLogger(StoreController.class);

	@Autowired
	protected StoreService storeService;

	@PostMapping(value = "/calculate")
	public Double calculateRate(@RequestBody List<CartDTO> cartDTOList) {
		Double responseDto = storeService.calculate(cartDTOList);
		return responseDto;

	}
	
	@PostMapping(value = "/saveandGenerate")
	public BuyerDTO saveandGenerate(@RequestBody BuyerDTO buyerDTO) {
		
		return storeService.saveandGenerate(buyerDTO);

	}

	@GetMapping(value = "/cartList")
	public List<CartDTO> getcart() {
		return storeService.getCartDetials();
	}
	
	@GetMapping(value = "/buyerList")
	public List<BuyerDTO> buyersList(){
		return storeService.getBuyerDetails();
		
	}
	
	@GetMapping(value = "/buyerListByName")
	public List<BuyerDTO> buyerListByName(@RequestParam String name){
		return storeService.getBuyerDetailsByName(name);
		
	}
	
	@GetMapping(value = "/buyerListByDate")
	public List<BuyerDTO> buyerListByName(@RequestParam Date sellingDate){
		return storeService.getBuyerDetailsByDate(sellingDate);
		
	}
	
	
	@GetMapping(value = "/maxBillNo")
	public int maxBillNo(){
		return storeService.getMaxBill_No();
		
	}
}

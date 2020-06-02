package com.hadware.store.mapper;

import java.util.List;

import com.hadware.store.dto.BuyerDTO;
import com.hadware.store.model.Buyer;

public interface BuyerMapper {
	
Buyer map(BuyerDTO buyerdto);

BuyerDTO map(Buyer buyer);

List<BuyerDTO> map(List<Buyer> buyerList);
	
 

}

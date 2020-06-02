package com.hadware.store.mapper;

import java.util.List;

import org.springframework.stereotype.Component;

import com.hadware.store.dto.BuyerDTO;
import com.hadware.store.model.Buyer;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

@Component
public class BuyerMapperImpl  implements BuyerMapper{
	
/**mapper**/	
MapperFacade mapper;
	

public BuyerMapperImpl() {
	MapperFactory mapperfactory = new DefaultMapperFactory.Builder().build();
	mapperfactory.classMap(Buyer.class, BuyerDTO.class);
	mapper=mapperfactory.getMapperFacade();
}
	public BuyerDTO map(Buyer buyer) {
		// TODO Auto-generated method stub
		return mapper.map(buyer, BuyerDTO.class);
	}
	public Buyer map(BuyerDTO buyerdto) {
		// TODO Auto-generated method stub
		return mapper.map(buyerdto, Buyer.class);
	}
	
	public List<BuyerDTO> map(List<Buyer> buyerList) {
		// TODO Auto-generated method stub
		return mapper.mapAsList(buyerList, BuyerDTO.class);
	}

	
}

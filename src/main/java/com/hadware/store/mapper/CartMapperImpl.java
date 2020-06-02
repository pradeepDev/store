package com.hadware.store.mapper;

import java.util.List;

import com.hadware.store.dto.BuyerDTO;
import com.hadware.store.dto.CartDTO;
import com.hadware.store.model.Buyer;
import com.hadware.store.model.Cart;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class CartMapperImpl {
	
	/**mapper**/	
	MapperFacade mapper;
		
	
	public CartMapperImpl() {
		MapperFactory mapperfactory = new DefaultMapperFactory.Builder().build();
		mapperfactory.classMap(Cart.class, CartDTO.class);
		mapper=mapperfactory.getMapperFacade();
	}

	public CartDTO map(Cart cart) {
		// TODO Auto-generated method stub
		return mapper.map(cart, CartDTO.class);
	}
	public Cart map(CartDTO cartDTO) {
		// TODO Auto-generated method stub
		return mapper.map(cartDTO, Cart.class);
	}
	
	public List<CartDTO> map(List<Cart> cartList) {
		// TODO Auto-generated method stub
		return mapper.mapAsList(cartList, CartDTO.class);
	}
}

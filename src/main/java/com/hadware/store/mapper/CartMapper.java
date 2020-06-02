package com.hadware.store.mapper;

import java.util.List;

import com.hadware.store.dto.BuyerDTO;
import com.hadware.store.dto.CartDTO;
import com.hadware.store.model.Buyer;
import com.hadware.store.model.Cart;

public interface CartMapper {

	Cart map(CartDTO cartDTO);

	CartDTO map(Cart buyer);

	List<CartDTO> map(List<Cart> cartDTOList);
}

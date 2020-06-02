package com.hadware.store.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hadware.store.model.Buyer;
import com.hadware.store.model.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {
	@Query(value = "SELECT t FROM Cart t WHERE Buyer_id = :i ")
	List<Cart> getCartDetials(@Param("i") int i);

	}

package com.hadware.store.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hadware.store.model.Buyer;
import com.hadware.store.model.Cart;

public interface BuyerRepository extends JpaRepository<com.hadware.store.model.Buyer, Long> {
	@Query(value = "SELECT t FROM Buyer t WHERE ID = ('%'+ :string +'%') ")
	List<Buyer> find(String string);
    
	@Query(value = "SELECT t FROM Buyer t WHERE t.buyerName like concat('%',:i,'%')")
	List<Buyer> getBuyerListByName(@Param("i") String i);
	
	@Query(value = "SELECT t FROM Buyer t WHERE t.sellingDate = :i ")
	List<Buyer> getBuyerListByDate(@Param("i") Date i);
	
	@Query(value = "select MAX(billNo) from Buyer")
	int getMaxBill_No();
}

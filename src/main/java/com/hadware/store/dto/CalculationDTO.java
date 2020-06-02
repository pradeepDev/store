package com.hadware.store.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CalculationDTO {

	private double totalCost;
	private double cgst;
	private double sgst;
	private double totalAmountAfterGST;
	private double discount;
	private double grandTotal;
}

package com.finder.model;

import java.util.Calendar;

public class FridgeItem extends Item {
	
	private int amount;
	private Calendar useBy;
	
	public FridgeItem(String name, int amount, Unit unitOfMeasurement, Calendar useBy) {
		super(name, unitOfMeasurement);
		this.amount = amount;
		this.useBy = useBy;
	}

	public int getAmount() {
		return amount;
	}

	public Calendar getUseBy() {
		return useBy;
	}
	
	
}

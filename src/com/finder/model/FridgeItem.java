package com.finder.model;

import java.util.Calendar;

public class FridgeItem extends Item implements Comparable<FridgeItem> {

//	private int amount;
	private Calendar useBy;

	public FridgeItem(String name, int amount, Unit unitOfMeasurement,
			Calendar useBy) {
		super(name, unitOfMeasurement);
//		this.amount = amount;
		this.useBy = useBy;
	}

	public Calendar getUseBy() {
		return useBy;
	}

	@Override
	public int compareTo(FridgeItem arg0) {
		if (useBy.before(arg0))
			return -1;
		if (useBy.after(arg0))
			return 1;
		return 0;
	}

}

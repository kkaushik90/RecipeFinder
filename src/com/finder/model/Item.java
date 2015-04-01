package com.finder.model;

public class Item {
	
	private String name;
	private int amount;
	private Unit unitOfMeasurement;

	public Item(String name, Unit unitOfMeasurement) {
		super();
		this.name = name;
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public String getName() {
		return name;
	}
	
	public int getAmount() {
		return amount;
	}

	public Unit getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

}

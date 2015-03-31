package com.finder.model;

public class Item {
	
	private String name;
	private Unit unitOfMeasurement;

	public Item(String name, Unit unitOfMeasurement) {
		super();
		this.name = name;
		this.unitOfMeasurement = unitOfMeasurement;
	}

	public String getName() {
		return name;
	}

	public Unit getUnitOfMeasurement() {
		return unitOfMeasurement;
	}

}

package com.finder.model;

public class Item {

	private String name;
	private int amount;
	private Unit unitOfMeasurement;

	public Item(String name, int amount, Unit unitOfMeasurement) {
		super();
		this.name = name;
		this.amount = amount;
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

	public void addAmount(int amount) {
		this.amount += amount;
	}
}

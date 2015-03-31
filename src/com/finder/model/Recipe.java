package com.finder.model;

import java.util.List;

public class Recipe {
	
	private String name;
	private List<FridgeItem> ingredients;

	public Recipe(String name, List<FridgeItem> ingredients) {
		this.name = name;
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public List<FridgeItem> getIngredients() {
		return ingredients;
	}

}

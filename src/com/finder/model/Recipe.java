package com.finder.model;

import java.util.List;

public class Recipe {
	
	private String name;
	private List<Item> ingredients;

	public Recipe(String name, List<Item> ingredients) {
		this.name = name;
		this.ingredients = ingredients;
	}

	public String getName() {
		return name;
	}

	public List<Item> getIngredients() {
		return ingredients;
	}

}

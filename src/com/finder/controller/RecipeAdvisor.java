package com.finder.controller;

import java.util.ArrayList;
import java.util.List;

import com.finder.model.FridgeItem;
import com.finder.model.Item;
import com.finder.model.Recipe;
import com.finder.repositories.FridgeRepository;
import com.finder.repositories.RecipeRepository;

public class RecipeAdvisor {

	public static Recipe findRecipe() {
		List<Recipe> recipesFound;
		List<FridgeItem> usableFridgeItems = FridgeRepository.getInstance()
				.getItemsInFridgeWithoutOutOfDateSortedByDate();
		List<Recipe> availableRecipes = RecipeRepository.getInstance()
				.getRecipes();

		recipesFound = getAllPossibleRecipes(availableRecipes);

		//TODO find best recipe choice based on use by date
		if (recipesFound != null)
			return recipesFound.get(0);
		return null;
	}

	private static List<Recipe> getAllPossibleRecipes(
			List<Recipe> availableRecipes) {
		List<Recipe> recipesFound = new ArrayList<>();
		for (Recipe recipe : availableRecipes) {
			boolean isRecipePossible = true;
			for (Item item : recipe.getIngredients()) {
				FridgeItem fridgeItem = FridgeRepository.getInstance()
						.getItemByName(item.getName());
				if (fridgeItem == null
						|| item.getUnitOfMeasurement() != fridgeItem
								.getUnitOfMeasurement()
						|| item.getAmount() > fridgeItem.getAmount())
					isRecipePossible = false;
			}
			if (isRecipePossible)
				recipesFound.add(recipe);
		}
		return recipesFound;
	}
}

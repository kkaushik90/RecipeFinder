package com.finder.strategies;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import com.finder.model.FridgeItem;
import com.finder.model.Item;
import com.finder.model.Recipe;
import com.finder.repositories.FridgeRepository;

public class IngredientsAvailabilityStrategy implements
		RecipeListFilterStrategy {

	@Override
	public List<Recipe> getFilteredRecipeList(List<Recipe> recipes) {
		List<Recipe> recipesFound = new ArrayList<>();
		Calendar today = Calendar.getInstance();
		for (Recipe recipe : recipes) {
			boolean isRecipePossible = true;
			for (Item item : recipe.getIngredients()) {
				FridgeItem fridgeItem = FridgeRepository.getInstance()
						.getItemByName(item.getName());
				if (fridgeItem == null
						|| item.getUnitOfMeasurement() != fridgeItem
								.getUnitOfMeasurement()
						|| item.getAmount() > fridgeItem.getAmount()
						|| fridgeItem.getUseBy().before(today)) {
					isRecipePossible = false;
					break;
				}
			}
			if (isRecipePossible)
				recipesFound.add(recipe);
		}
		return recipesFound;
	}

}

package com.finder.strategies;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.finder.model.FridgeItem;
import com.finder.model.Item;
import com.finder.model.Recipe;
import com.finder.repositories.FridgeRepository;

public class SoonestUseByDateStrategy implements RecipeListFilterStrategy {

	private Item soonestUseByItem;
	private Calendar soonestUseByItemDate;
	private Recipe mostPreferredRecipe;

	@Override
	public List<Recipe> getFilteredRecipeList(List<Recipe> recipes) {
		for (Recipe recipe : recipes) {
			for (Item item : recipe.getIngredients()) {
				FridgeItem fridgeItem = FridgeRepository.getInstance()
						.getItemByName(item.getName());
				if (soonestUseByItemDate == null
						|| soonestUseByItemDate.after(fridgeItem.getUseBy())) {
					soonestUseByItem = fridgeItem;
					soonestUseByItemDate = fridgeItem.getUseBy();
					mostPreferredRecipe = recipe;
				}
			}
		}
		List<Recipe> filteredList = new ArrayList<>();
		filteredList.add(mostPreferredRecipe);
		return filteredList;
	}

}

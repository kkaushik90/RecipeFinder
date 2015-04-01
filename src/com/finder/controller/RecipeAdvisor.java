package com.finder.controller;

import java.util.List;

import com.finder.model.Recipe;
import com.finder.repositories.RecipeRepository;
import com.finder.strategies.IngredientsAvailabilityStrategy;
import com.finder.strategies.SoonestUseByDateStrategy;

public class RecipeAdvisor {

	public static Recipe findRecipe() {
		List<Recipe> recipesFound;
		List<Recipe> allRecipes = RecipeRepository.getInstance().getRecipes();

		recipesFound = new RecipeFilterContext(
				new IngredientsAvailabilityStrategy())
				.getFilteredRecipes(allRecipes);

		if (recipesFound != null && recipesFound.size() > 1)
			recipesFound = new RecipeFilterContext(
					new SoonestUseByDateStrategy())
					.getFilteredRecipes(recipesFound);
		if (recipesFound != null && recipesFound.size() == 1)
			return recipesFound.get(0);
		return null;
	}

}

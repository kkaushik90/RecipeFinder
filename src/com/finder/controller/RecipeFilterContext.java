package com.finder.controller;

import java.util.List;

import com.finder.model.Recipe;
import com.finder.strategies.RecipeListFilterStrategy;

public class RecipeFilterContext {

	private RecipeListFilterStrategy recipeFilterStrategy;

	public RecipeFilterContext(RecipeListFilterStrategy recipeFilterStrategy) {
		this.recipeFilterStrategy = recipeFilterStrategy;
	}

	public List<Recipe> getFilteredRecipes(List<Recipe> recipes) {
		return recipeFilterStrategy.getFilteredRecipeList(recipes);
	}
}

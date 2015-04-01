package com.finder.strategies;

import java.util.List;

import com.finder.model.Recipe;

public interface RecipeListFilterStrategy {

	public List<Recipe> getFilteredRecipeList(List<Recipe> recipes);
}

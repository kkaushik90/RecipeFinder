package com.finder.repositories;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.finder.model.Recipe;

public class RecipeRepository {

	private List<Recipe> recipes;
	private static RecipeRepository recipeRepository;

	public static RecipeRepository getInstance() {
		if (recipeRepository == null)
			recipeRepository = new RecipeRepository();
		return recipeRepository;
	}

	private RecipeRepository() {
		recipes = new ArrayList<Recipe>();
	}

	public List<Recipe> getRecipes() {
		return recipes;
	}

	public void setRecipes(List<Recipe> recipes) {
		this.recipes = recipes;
	}

	public void addRecipe(Recipe recipe) {
		if (recipe != null)
			recipes.add(recipe);
	}

}

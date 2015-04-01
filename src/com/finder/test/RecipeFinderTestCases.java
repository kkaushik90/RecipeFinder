package com.finder.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.finder.controller.RecipeAdvisor;
import com.finder.controller.RecipeFilterContext;
import com.finder.model.FridgeItem;
import com.finder.model.Item;
import com.finder.model.Recipe;
import com.finder.model.Unit;
import com.finder.repositories.FridgeRepository;
import com.finder.repositories.RecipeRepository;
import com.finder.strategies.IngredientsAvailabilityStrategy;

public class RecipeFinderTestCases {

	@Before
	public void setUp() throws Exception {
		List<FridgeItem> fridgeItems = new ArrayList<>();
		Calendar useByDate = new GregorianCalendar(2015, 11, 25);
		fridgeItems.add(new FridgeItem("bread", 10, Unit.SLICES, useByDate));
		fridgeItems.add(new FridgeItem("cheese", 10, Unit.SLICES, useByDate));
		fridgeItems.add(new FridgeItem("butter", 250, Unit.GRAMS, useByDate));
		useByDate = new GregorianCalendar(2015, 11, 2);
		fridgeItems.add(new FridgeItem("peanut butter", 250, Unit.GRAMS,
				useByDate));
		useByDate = new GregorianCalendar(2015, 4, 2);
		fridgeItems.add(new FridgeItem("mixed salad", 150, Unit.GRAMS,
				useByDate));

		FridgeRepository.getInstance().setItemsInFridge(fridgeItems);

		List<Recipe> recipeList = new ArrayList<>();

		List<Item> ingredients = new ArrayList<>();
		ingredients.add(new Item("bread", 2, Unit.SLICES));
		ingredients.add(new Item("cheese", 2, Unit.SLICES));

		recipeList.add(new Recipe("grilled cheese on toast", ingredients));

		ingredients = new ArrayList<>();
		ingredients.add(new Item("bread", 2, Unit.SLICES));
		ingredients.add(new Item("mixed salad", 100, Unit.GRAMS));

		recipeList.add(new Recipe("salad sandwich", ingredients));

		RecipeRepository.getInstance().setRecipes(recipeList);
	}

	@Test
	public void test() {
		Recipe suggestedRecipe = RecipeAdvisor.findRecipe();
		assertEquals("salad sandwich", suggestedRecipe.getName());
	}

	@Test
	public void fridgeRepositoryShouldHaveTenBreads() {
		assertEquals(10, FridgeRepository.getInstance().getItemByName("bread")
				.getAmount());
	}

	@Test
	public void ingredientsAvailabilityStrategyTest() {
		List<Recipe> recipesFound = new RecipeFilterContext(
				new IngredientsAvailabilityStrategy())
				.getFilteredRecipes(RecipeRepository.getInstance().getRecipes());
		assertEquals(2, recipesFound.size());
	}
}

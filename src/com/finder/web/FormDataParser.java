package com.finder.web;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.finder.model.FridgeItem;
import com.finder.model.Item;
import com.finder.model.Recipe;
import com.finder.model.Unit;

public class FormDataParser {

	public static List<Recipe> parseJsonToRecipeList(String formParameterJson) {
		List<Recipe> recipes = new ArrayList<>();
		try {
			JSONArray recipeJsonArr = new JSONArray(formParameterJson);
			for (int i = 0; i < recipeJsonArr.length(); i++) {
				List<Item> ingredients = new ArrayList<>();
				JSONObject recipeJsonObject = recipeJsonArr.getJSONObject(i);
				JSONArray ingredientsJsonArr = recipeJsonObject
						.getJSONArray("ingredients");
				for (int j = 0; j < ingredientsJsonArr.length(); j++) {
					ingredients.add(new Item(ingredientsJsonArr
							.getJSONObject(j).getString("item"), Integer
							.parseInt(ingredientsJsonArr.getJSONObject(j)
									.getString("amount")), Unit
							.valueOf(ingredientsJsonArr.getJSONObject(j)
									.getString("unit").toUpperCase())));
				}
				recipes.add(new Recipe(recipeJsonObject.getString("name"),
						ingredients));
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return recipes;
	}

	public static List<FridgeItem> parseCsvToFridgeItemList(
			String formParameterCsv) {
		List<FridgeItem> fridgeItems = new ArrayList<>();
		String csvLines[] = formParameterCsv.split("\n");
		for (String line : csvLines) {
			System.out.println("line: " + line);
			if (line.trim().length() < 3)
				break;
			String csvObjectStr[] = line.split(",");
			System.out.println(csvObjectStr[0]);
			System.out.println(csvObjectStr[1]);
			String name = csvObjectStr[0];
			int amount = Integer.parseInt(csvObjectStr[1]);
			Unit unitOfMeasurement = Unit
					.valueOf(csvObjectStr[2].toUpperCase());
			Calendar useBy = parseStringFromCsvToCalendar(csvObjectStr[3]);
			FridgeItem fridgeItem = new FridgeItem(name, amount,
					unitOfMeasurement, useBy);
			fridgeItems.add(fridgeItem);
		}
		return fridgeItems;
	}

	private static Calendar parseStringFromCsvToCalendar(String dateStr) {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy",
				Locale.getDefault());
		try {
			cal.setTime(sdf.parse(dateStr));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return cal;
	}
}

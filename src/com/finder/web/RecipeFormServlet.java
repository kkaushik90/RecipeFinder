package com.finder.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.finder.controller.RecipeAdvisor;
import com.finder.model.Recipe;
import com.finder.repositories.FridgeRepository;
import com.finder.repositories.RecipeRepository;

/**
 * Servlet implementation class RecipeFormServlet
 */
@WebServlet("/RecommendedRecipe")
public class RecipeFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public RecipeFormServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		FridgeRepository.getInstance().setItemsInFridge(
				FormDataParser.parseCsvToFridgeItemList(request.getParameter("fridge")));
		RecipeRepository.getInstance().setRecipes(
				FormDataParser.parseJsonToRecipeList(request.getParameter("recipes")));
		Recipe recommendedRecipe = RecipeAdvisor.findRecipe();
		if (recommendedRecipe != null)
			response.getWriter().print(
					"Recommended recipe: " + recommendedRecipe.getName());
		else
			response.getWriter().print("Order takeout.");
	}

}

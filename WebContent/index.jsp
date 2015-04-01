<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="stylesheets/public.css" rel="stylesheet" type="text/css">
<title>Recipe Finder by Kartik Kaushik</title>
</head>
<body>
	<h1>Recipe Finder</h1>
	By Kartik Kaushik
	<br />
	<br />
	<form name="finder_form" action="RecommendedRecipe" method="POST"
		id='finder-form'>
		<label>Fridge items csv</label><br />
		<textarea name="fridge" id="fridge">
bread,10,slices,25/12/2014
cheese,10,slices,25/12/2014
butter,250,grams,25/12/2014
peanut butter,250,grams,2/12/2014
mixed salad,150,grams,26/12/2013
		</textarea>
		<br /> <br /> <label>Recipes json</label><br />
		<textarea name="recipes" id="recipes">
[
&nbsp;&nbsp;{
&nbsp;&nbsp;&nbsp;&nbsp;"name": "grilled cheese on toast", 
&nbsp;&nbsp;&nbsp;&nbsp;"ingredients": [
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{ "item":"bread", "amount":"2", "unit":"slices"}, 
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{ "item":"cheese", "amount":"2", "unit":"slices"}
&nbsp;&nbsp;&nbsp;&nbsp;]
&nbsp;&nbsp;},
&nbsp;&nbsp;{
&nbsp;&nbsp;&nbsp;&nbsp;"name": "salad sandwich",
&nbsp;&nbsp;&nbsp;&nbsp;"ingredients": [
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{ "item":"bread", "amount":"2", "unit":"slices"},
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;{ "item":"mixed salad", "amount":"100", "unit":"grams"}
&nbsp;&nbsp;&nbsp;&nbsp;]
&nbsp;&nbsp;}
]</textarea>
		<br /> <br />
		<button id="register-button" type="submit" name="submit"
			value="Submit">Find</button>
	</form>
</body>
</html>
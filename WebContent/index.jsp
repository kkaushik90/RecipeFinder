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
bread,10,slices,25/12/2015
cheese,10,slices,25/12/2015
butter,250,grams,25/12/2015
peanut butter,250,grams,2/12/2015
mixed salad,150,grams,26/12/2014
		</textarea>
		<br /> <br /> <label>Recipes json</label><br />
		<textarea name="recipes" id="recipes">
[
    {
        "name": "grilled cheese on toast",
        "ingredients": [
            {
                "item": "bread",
                "amount": "2",
                "unit": "slices"
            },
            {
                "item": "cheese",
                "amount": "2",
                "unit": "slices"
            }
        ]
    },
    {
        "name": "salad sandwich",
        "ingredients": [
            {
                "item": "bread",
                "amount": "2",
                "unit": "slices"
            },
            {
                "item": "mixed salad",
                "amount": "100",
                "unit": "grams"
            }
        ]
    }
]
</textarea>
		<br /> <br />
		<button id="register-button" type="submit" name="submit"
			value="Submit">Find</button>
	</form>
</body>
</html>
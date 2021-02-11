package Business.Coffee;

import Business.Coffee.Ingredients.Ingredient;

public class Recipe {
	public Ingredient ingredient; 
	public String command; 
	public Recipe(String command, Ingredient ingredient) {
		this.command =command; 
		this.ingredient = ingredient; 
	}
}

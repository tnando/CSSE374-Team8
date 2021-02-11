package Business.Coffee;

import java.util.ArrayList;

import Business.Coffee.Ingredients.Ingredient;

public class Recipe {
	public ArrayList<CommandStep> commandSteps; 
	public String drinkname; 
	public Recipe(String drinkname, ArrayList<CommandStep> list) {
		this.drinkname=drinkname; 
		this.commandSteps = list; 
		
	}
}

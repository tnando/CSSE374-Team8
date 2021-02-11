package Business.Coffee;

import Business.Coffee.Ingredients.Ingredient;

public class CommandStep {
	public String command; 
	public Ingredient ingredient; 
	
	public CommandStep(String command, Ingredient ingredient) {
		this.command = command; 
		this.ingredient=ingredient; 
	}
}

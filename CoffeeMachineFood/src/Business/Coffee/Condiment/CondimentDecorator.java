package Business.Coffee.Condiment;

import Business.Coffee.Drink.Drink;
import Business.Coffee.Drink.IDrink;

public abstract class CondimentDecorator implements IDrink {

	String description = "drink";
	
	public abstract String getIngredients();
	
	
}

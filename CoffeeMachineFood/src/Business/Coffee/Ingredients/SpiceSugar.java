package Business.Coffee.Ingredients;

import Business.Coffee.Condiment.CondimentDecorator;
import Business.Coffee.Drink.IDrink;

public class SpiceSugar extends CondimentDecorator implements Spice {
	IDrink drink;
	
	public SpiceSugar (IDrink drink) {
		this.drink = drink;
	}

	public String toString() {
		return "Sugar";
	}

	public String getIngredients() {
		return this.drink.getIngredients() + ", Sugar";
	}
}

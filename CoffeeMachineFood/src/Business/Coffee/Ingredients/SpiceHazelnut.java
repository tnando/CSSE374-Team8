package Business.Coffee.Ingredients;

import Business.Coffee.Condiment.CondimentDecorator;
import Business.Coffee.Drink.IDrink;

public class SpiceHazelnut extends CondimentDecorator implements Spice {
	IDrink drink;
	
	public SpiceHazelnut (IDrink drink) {
		this.drink = drink;
	}

	public String toString() {
		return "Hazelnut";
	}

	public String getIngredients() {
		return this.drink.getIngredients() + ", Hazelnut";
	}
}

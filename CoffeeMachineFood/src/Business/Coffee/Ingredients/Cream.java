package Business.Coffee.Ingredients;

import Business.Coffee.Condiment.CondimentDecorator;
import Business.Coffee.Drink.IDrink;

public class Cream extends CondimentDecorator implements Milk {
	
	IDrink drink;
	
	public Cream (IDrink drink) {
		this.drink = drink;
	}

	public String toString() {
		return "Cream";
	}

	public String getIngredients() {
		return this.drink.getIngredients() + ", Cream";
	}

}

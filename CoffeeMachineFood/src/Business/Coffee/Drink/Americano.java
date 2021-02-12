package Business.Coffee.Drink;

import Business.Coffee.Ingredients.Coffee;
import Business.Coffee.Ingredients.CoffeeCaffeine;
import Business.Coffee.Ingredients.Milk;
import Business.Coffee.Ingredients.Spice;
import Business.Coffee.Ingredients.Topping;

public class Americano extends Drink{
	
	String createCoffee() {
		return (new CoffeeCaffeine()).toString();
	}

	String createMilk() {
		return "";
	}

	String createSpice() {
		return "";
	}

	String createTopping() {
		return "";
	}

}

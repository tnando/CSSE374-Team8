package Business.Coffee.Drink;

import Business.Coffee.Ingredients.CoffeeDecaf;

public class Decaf extends Drink {

	String createCoffee() {
		return (new CoffeeDecaf()).toString();
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

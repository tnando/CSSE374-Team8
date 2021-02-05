package Business.Coffee.Drink;

import Business.Coffee.Ingredients.CoffeeCaffeine;

public class Espresso extends Drink {

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

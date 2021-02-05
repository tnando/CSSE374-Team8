package Business.Coffee.Drink;

import Business.Coffee.Ingredients.CoffeeCaffeine;

public class ColombiaDark extends Drink {

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

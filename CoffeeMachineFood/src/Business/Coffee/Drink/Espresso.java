package Business.Coffee.Drink;

import Business.Coffee.Ingredients.CoffeeCaffeine;
import Business.Coffee.Ingredients.EspressoBean;

public class Espresso extends Drink {

	String createCoffee() {
		return (new EspressoBean()).toString();
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

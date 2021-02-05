package Business.Coffee.Drink;

import Business.Coffee.Ingredients.CoffeeCaffeine;
import Business.Coffee.Ingredients.Cream;
import Business.Coffee.Ingredients.SpiceNutmeg;
import Business.Coffee.Ingredients.SpicePumpkin;
import Business.Coffee.Ingredients.WhippedCream;

public class PumpkinSpice extends Drink {

	String createCoffee() {
		return (new CoffeeCaffeine()).toString();
	}

	String createMilk() {
		return (new Cream()).toString();
	}

	String createSpice() {
		String toReturn = "";
		toReturn += (new SpicePumpkin()).toString() + ", ";
		toReturn += (new SpiceNutmeg()).toString();
		return toReturn;
	}

	String createTopping() {
		return (new WhippedCream()).toString();
	}

}

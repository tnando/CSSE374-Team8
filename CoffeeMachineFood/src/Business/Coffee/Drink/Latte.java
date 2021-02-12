package Business.Coffee.Drink;

import Business.Coffee.Ingredients.Coffee;
import Business.Coffee.Ingredients.CoffeeCaffeine;
import Business.Coffee.Ingredients.EspressoBean;
import Business.Coffee.Ingredients.Milk;
import Business.Coffee.Ingredients.MilkRegular;
import Business.Coffee.Ingredients.Spice;
import Business.Coffee.Ingredients.Topping;
import Business.Coffee.Ingredients.WhippedCream;

public class Latte extends Drink{

	String createCoffee() {
		return (new EspressoBean()).toString();
	}

	String createMilk() {
		return (new MilkRegular()).toString();
	}

	String createSpice() {
		return "";
	}

	String createTopping() {
		return (new WhippedCream()).toString();
	}

}

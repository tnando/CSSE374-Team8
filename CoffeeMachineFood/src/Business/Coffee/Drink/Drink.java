package Business.Coffee.Drink;

import Business.Coffee.Ingredients.*;

public abstract class Drink {
	
	public String createDrink() {
		String ingredients = "";
		String coffee = createCoffee();
		if(!(coffee.equals(""))){
			ingredients += coffee;
			ingredients += ", ";
		}
		String milk = createMilk();
		if(!(milk.equals(""))){
			ingredients += milk;
			ingredients += ", ";
		}
		String spice = createSpice();
		if(!(spice.equals(""))){
			ingredients += spice;
			ingredients += ", ";
		}
		String topping = createTopping();
		if(!(topping.equals(""))){
			ingredients += topping;
		}
		return ingredients;
	}
	
	abstract String createCoffee();
	abstract String createMilk();
	abstract String createSpice();
	abstract String createTopping();
}

package Business.Coffee.Drink;

import Business.Coffee.Ingredients.*;

public abstract class Drink implements IDrink {
	
	public String createDrink() {
		String ingredients = "";
		String coffee = createCoffee();
		if(!(coffee.equals(""))){
			ingredients += coffee;
		}
		String milk = createMilk();
		if(!(milk.equals(""))){
			ingredients += ", ";
			ingredients += milk;
		}
		String spice = createSpice();
		if(!(spice.equals(""))){
			ingredients += ", ";
			ingredients += spice;
		}
		String topping = createTopping();
		if(!(topping.equals(""))){
			ingredients += ", ";
			ingredients += topping;
		}
		return ingredients;
	}
	
	public String getIngredients() {
		return this.createDrink();
	}
	
	abstract String createCoffee();
	abstract String createMilk();
	abstract String createSpice();
	abstract String createTopping();
}

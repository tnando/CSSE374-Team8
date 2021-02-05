package Business.Coffee;

import Business.Coffee.Drink.*;

public class DrinkFactory {
	public String createDrink(String type) {
		if (type.contains("Americano")) {
			return (new Americano()).createDrink();
		} else if (type.contains("Latte")) {
			return (new Latte()).createDrink();
		} else if (type.contains("Decaf")) {
			return (new Decaf()).createDrink();
		} else if (type.contains("Espresso")) {
			return (new Espresso()).createDrink();
		} else if (type.contains("Colombia Dark")) {
			return (new ColombiaDark()).createDrink();
		} else if (type.contains("Pumpkin Spice")) {
			return (new PumpkinSpice()).createDrink();
		} else {
			return null;
		}
	}
}

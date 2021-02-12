package Business.Coffee;

import Business.Coffee.Drink.*;

//A1
public class DrinkFactory {
	public Drink createDrink(String type) {
		if (type.contains("Americano")) {
			return new Americano();
		} else if (type.contains("Latte")) {
			return new Latte();
		} else if (type.contains("Decaf")) {
			return new Decaf();
		} else if (type.contains("Espresso")) {
			return new Espresso();
		} else if (type.contains("Colombia Dark")) {
			return new ColombiaDark();
		} else if (type.contains("Pumpkin Spice")) {
			return new PumpkinSpice();
		} else {
			return null;
		}
	}
}

package Business.Coffee.Machine;

import org.json.simple.JSONArray;

import Business.Coffee.Condiment.CondimentBehavior;
import Business.Coffee.Drink.Drink;
import Business.Coffee.Drink.IDrink;

public abstract class CoffeeMachine {
	
	String coffeeMachineID;
	CondimentBehavior cb;
	
	public CoffeeMachine(String id, CondimentBehavior cb) {
		this.coffeeMachineID = id;
		this.cb = cb;
	}
	
	public IDrink makeCoffee(IDrink drink, JSONArray condiments) {
		return cb.addCondiments(drink, condiments);
	}
	
	public CondimentBehavior getCondimentBehavior() {
		return this.cb;
	}
	
}

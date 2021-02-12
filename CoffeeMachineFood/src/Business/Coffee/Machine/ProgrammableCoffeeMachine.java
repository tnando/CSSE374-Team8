package Business.Coffee.Machine;

import org.json.simple.JSONArray;

import Business.Coffee.Condiment.CondimentBehavior;
import Business.Coffee.Drink.Drink;
import Business.Coffee.Drink.IDrink;

public class ProgrammableCoffeeMachine extends CoffeeMachine{

	public ProgrammableCoffeeMachine(String id, CondimentBehavior cb) {
		super(id, cb);
		
	}
	
	@Override 
	public IDrink makeCoffee(IDrink drink, JSONArray condiments) {
		return null;
		
	}
	

}

package Business.Coffee.Machine;

import Business.Coffee.Recipe;
import Business.Coffee.Condiment.CondimentBehavior;

public class ProgrammableCoffeeMachine extends CoffeeMachine{

	Recipe recipe; 
	public ProgrammableCoffeeMachine(String id, CondimentBehavior cb, Recipe recipe) {
		super(id, cb);
		this.recipe = recipe; 
		
	}
	
	@Override 
	public String makeCoffee(String[] condiments) {
		return null;
		
	}
	

}

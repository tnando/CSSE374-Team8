package Business.Coffee;

import Business.Coffee.Condiment.CondimentBehavior;
import Business.Coffee.Machine.CoffeeMachine;

public class ProgrammableCoffeeMachine  extends CoffeeMachine{

	Recipe recipe; 
	public ProgrammableCoffeeMachine(String id, CondimentBehavior cb, Recipe recipe) {
		super(id, cb);
		this.recipe = recipe; 
		
	}
	
	@Override 
	public String makeCoffee(String[] condiments) {
		
	}
	

}

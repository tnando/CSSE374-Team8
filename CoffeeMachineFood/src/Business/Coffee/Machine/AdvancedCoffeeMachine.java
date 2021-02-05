package Business.Coffee.Machine;

import Business.Coffee.Condiment.CondimentAdd;

public class AdvancedCoffeeMachine extends CoffeeMachine {

	public AdvancedCoffeeMachine(String id) {
		super(id, new CondimentAdd());
	}
	
}

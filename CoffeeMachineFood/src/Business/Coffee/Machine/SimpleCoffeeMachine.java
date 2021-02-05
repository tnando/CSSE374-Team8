package Business.Coffee.Machine;

import Business.Coffee.Condiment.CondimentNone;

public class SimpleCoffeeMachine extends CoffeeMachine {

	public SimpleCoffeeMachine(String id) {
		super(id, new CondimentNone());
	}

}

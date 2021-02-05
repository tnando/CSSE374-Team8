package Business.Coffee.Machine;

import Business.Coffee.Condiment.CondimentBehavior;

public abstract class CoffeeMachine {
	
	String coffeeMachineID;
	CondimentBehavior cb;
	
	public CoffeeMachine(String id, CondimentBehavior cb) {
		this.coffeeMachineID = id;
		this.cb = cb;
	}
	
	public String makeCoffee(String[] condiments) {
		String toReturn = "";
		toReturn += "Making coffee...\n";
		toReturn += "Made coffee\n";
		toReturn += cb.addCondiments(condiments);
		
		System.out.println(toReturn);
		return toReturn;
	}
	
}

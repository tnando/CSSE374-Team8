package Control;

import Coffee.CoffeeMachine;

public class ConcreteController implements Controller {
	
	String controllerID;
	CoffeeMachine cm;
	
	ConcreteController (String id, CoffeeMachine cm) {
		this.controllerID = id;
		this.cm = cm;
	}
	
	public void makeCoffee(String[] condiments) {
		cm.makeCoffee(condiments);
	}
	
	public void update() {
		
	}
	
}

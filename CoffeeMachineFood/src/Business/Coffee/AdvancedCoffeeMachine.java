package Business.Coffee;

public class AdvancedCoffeeMachine extends CoffeeMachine {

	public AdvancedCoffeeMachine(String id) {
		super(id, new CondimentAdd());
	}
	
}

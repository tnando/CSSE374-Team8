package Business.Coffee;

public class CoffeeMachineFactory {
	public CoffeeMachine generateMachine(int order, CondimentBehavior behavior) {
		if(order==1) {
			return new SimpleCoffeeMachine("1");
		}
		else if(order==2) {
			return new ProgrammableCoffeeMachine("2", behavior);
		}
		else {
			return new AdvancedCoffeeMachine("3");
		}
	}
}


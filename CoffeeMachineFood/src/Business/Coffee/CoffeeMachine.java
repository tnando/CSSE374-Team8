package Business.Coffee;

public abstract class CoffeeMachine {
	
	String coffeeMachineID;
	CondimentBehavior cb;
	
	public CoffeeMachine(String id, CondimentBehavior cb) {
		this.coffeeMachineID = id;
		this.cb = cb;
	}
	
	public void makeCoffee(String[] condiments) {
		System.out.println("Making coffee...");
		System.out.println("Made coffee");
		cb.addCondiments(condiments);
	}
	
}

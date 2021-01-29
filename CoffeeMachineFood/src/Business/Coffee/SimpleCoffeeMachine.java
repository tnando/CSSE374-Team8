package Business.Coffee;

public class SimpleCoffeeMachine extends CoffeeMachine {

	public SimpleCoffeeMachine(String id) {
		super(id, new CondimentNone());
	}

}

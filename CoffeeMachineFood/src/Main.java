import Business.ConcreteController;
import Business.Controller;
import Business.Coffee.AdvancedCoffeeMachine;
import Business.Coffee.CoffeeMachine;
import Business.Coffee.SimpleCoffeeMachine;
import Data.CPS;
import Data.ConcreteCPS;
import Presentation.MobileApp;

public class Main {
	
	public static void main(String[] args) {
		
		ConcreteCPS cps = new ConcreteCPS();
		
		CoffeeMachine simple = new SimpleCoffeeMachine("1");
		Controller simpleController = new ConcreteController("1", simple, cps);
		
		CoffeeMachine advanced = new AdvancedCoffeeMachine("2");
		Controller advancedController = new ConcreteController("2", advanced, cps);
		
		cps.registerController(simpleController);
		cps.registerController(advancedController);
		
		
		MobileApp ma = new MobileApp(cps);
		for(int i = 1; i <= 3; i++) {
			ma.order(i);
		}
      
	}
}

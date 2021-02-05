import Business.ConcreteController;
import Business.Controller;
import Business.Coffee.Machine.AdvancedCoffeeMachine;
import Business.Coffee.Machine.CoffeeMachine;
import Business.Coffee.Machine.SimpleCoffeeMachine;
import Data.CPS;
import Data.ConcreteCPS;
import Presentation.MobileApp;

public class Main {
	
	public static void main(String[] args) {
		//D0
		
		ConcreteCPS cps = new ConcreteCPS();
		
		CoffeeMachine simple = new SimpleCoffeeMachine("1");
		Controller simpleController = new ConcreteController("1", simple, cps);
		
		CoffeeMachine advanced = new AdvancedCoffeeMachine("2");
		Controller advancedController = new ConcreteController("2", advanced, cps);
		
		cps.registerController(simpleController);
		cps.registerController(advancedController);
		
		MobileApp ma = new MobileApp(cps);
		for(int i = 1; i <= 4; i++) {
			ma.order(i);
		}
       
	}
}

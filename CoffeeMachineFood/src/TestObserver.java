import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import Business.ConcreteController;
import Business.Controller;
import Business.Coffee.CoffeeMachine;
import Business.Coffee.SimpleCoffeeMachine;
import Data.ConcreteCPS;

public class TestObserver {
	
	@Test
	public void testRegisterAndRemove() {
		ConcreteCPS cps = new ConcreteCPS();
		CoffeeMachine cm = new SimpleCoffeeMachine("1");
		ArrayList<Controller> controllers = new ArrayList<>();
		
		for(int i = 0 ; i < 5; i++) {
			Controller controller = new ConcreteController("1", cm, cps);
			controllers.add(controller);
			cps.registerController(controller);
		}
		
		assertEquals(cps.getControllersLength(), 5);
		
		
		for(int i = 0 ; i < 5; i++) {
			cps.removeController(controllers.get(i));
		}
		
		assertEquals(cps.getControllersLength(), 0);
	}
	
	@Test
	public void testNotify() {
		ConcreteCPS cps = new ConcreteCPS();
		CoffeeMachine cm = new SimpleCoffeeMachine("1");
		ArrayList<Controller> controllers = new ArrayList<>();
		
		for(int i = 0 ; i < 5; i++) {
			Controller controller = new ConcreteController("" + i, cm, cps);
			controllers.add(controller);
			cps.registerController(controller);
		}
		
		assertEquals(cps.notifyControllers(), "0");
		
		for(int i = 0; i < 2; i++) {
			controllers.get(i).setIsBusy(true);
		}
		
		assertEquals(cps.notifyControllers(), "2");
		
		for(int i = 2; i < 4; i++) {
			controllers.get(i).setIsBusy(true);
		}
		
		assertEquals(cps.notifyControllers(), "4");
		
		for(int i = 4; i < 5; i++) {
			controllers.get(i).setIsBusy(true);
		}
		
		assertEquals(cps.notifyControllers(), "-1");
	}

}

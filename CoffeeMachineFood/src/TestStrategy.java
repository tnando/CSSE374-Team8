import static org.junit.Assert.*;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import Business.Coffee.Machine.AdvancedCoffeeMachine;
import Business.Coffee.Machine.SimpleCoffeeMachine;

public class TestStrategy {

	//B1
	@Test
	public void testSimpleCoffeeMachine() {
		SimpleCoffeeMachine simple = new SimpleCoffeeMachine("1");
		
		String toMatch = simple.getCondimentBehavior().whoAdded();
		
		assertEquals("Barista", toMatch);
	}
	
	@Test
	public void testAdvancedCoffeeMachine() {
		AdvancedCoffeeMachine advanced = new AdvancedCoffeeMachine("1");
		
		String toMatch = advanced.getCondimentBehavior().whoAdded();
		
		assertEquals("Coffee Machine", toMatch);
	}
}

import static org.junit.Assert.*;

import org.junit.Test;

import Business.Coffee.Machine.AdvancedCoffeeMachine;
import Business.Coffee.Machine.SimpleCoffeeMachine;

public class TestStrategy {
	
	private String[] condiments = {"\"Name\": \"Cream\", \"qty\": 2", "\"Name\": \"Sugar\", \"qty\": 1"};
	
	//B1
	
	@Test
	public void testSimpleCoffeeMachine() {
		SimpleCoffeeMachine simple = new SimpleCoffeeMachine("1");
		
		String coffeeMade = simple.makeCoffee(condiments);
		String toMatch = "Making coffee...\n";
		toMatch += "Made coffee\n";
		toMatch += "Condiments must be added by the barista.\n";
		toMatch += "Condiments to Add: \n";
		toMatch += "   - \"Name\": \"Cream\", \"qty\": 2\n";
		toMatch += "   - \"Name\": \"Sugar\", \"qty\": 1\n";
		
		assertEquals(coffeeMade, toMatch);
	}
	
	@Test
	public void testAdvancedCoffeeMachine() {
		AdvancedCoffeeMachine advanced = new AdvancedCoffeeMachine("1");
		
		String coffeeMade = advanced.makeCoffee(condiments);
		String toMatch = "Making coffee...\n";
		toMatch += "Made coffee\n";
		toMatch += "Adding condiments...\n";
		toMatch += "Added \"Name\": \"Cream\", \"qty\": 2\n";
		toMatch += "Added \"Name\": \"Sugar\", \"qty\": 1\n";
		
		assertEquals(coffeeMade, toMatch);
	}
}

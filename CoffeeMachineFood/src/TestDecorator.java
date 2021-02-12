import static org.junit.Assert.assertEquals;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.junit.Before;
import org.junit.Test;

import Business.Coffee.DrinkFactory;
import Business.Coffee.Drink.IDrink;
import Business.Coffee.Machine.CoffeeMachine;
import Business.Coffee.Machine.SimpleCoffeeMachine;

public class TestDecorator {
	
	DrinkFactory df;
	JSONArray condiments;
	CoffeeMachine cm;
	
	@Before
	public void setup() {
		df = new DrinkFactory();
		cm = new SimpleCoffeeMachine("1");
		this.condiments = new JSONArray();
		JSONObject sugar = new JSONObject();
		JSONObject cream = new JSONObject();
		JSONObject hazelnut = new JSONObject();
		sugar.put("qty", 2);
		sugar.put("name", "Sugar");
		condiments.add(sugar);
		cream.put("qty", 1);
		cream.put("name", "Cream");
		condiments.add(cream);
		hazelnut.put("qty", 1);
		hazelnut.put("name", "Hazelnut");
		condiments.add(hazelnut);
	}

	@Test
	public void testDecorateWithCondiments() {
		IDrink drink = df.createDrink("Americano");
		String ingredients = cm.makeCoffee(drink, this.condiments).getIngredients();
		
		assertEquals(ingredients, "Coffee, Sugar, Sugar, Cream, Hazelnut");
		
		drink = df.createDrink("Latte");
		ingredients = cm.makeCoffee(drink, this.condiments).getIngredients();
		
		assertEquals(ingredients, "Espresso, Milk, Whipped Cream, Sugar, Sugar, Cream, Hazelnut");
	}
}

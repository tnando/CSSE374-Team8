import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Business.ConcreteController;
import Business.Controller;
import Business.Coffee.DrinkFactory;
import Business.Coffee.Drink.*;
import Business.Coffee.Machine.CoffeeMachine;
import Business.Coffee.Machine.SimpleCoffeeMachine;
import Data.ConcreteCPS;

//A1
public class TestFactory {
	
	DrinkFactory df; 
	
	@Before
	public void setup() {
		this.df = new DrinkFactory();
	}
	
	@Test
	public void testCreateAmericano() {
		Drink americano = df.createDrink("Americano");
		
		assertTrue(americano instanceof Americano);
	}
	
	@Test
	public void testCreateColombiaDark() {
		Drink colombiaDark = df.createDrink("Colombia Dark");
		
		assertTrue(colombiaDark instanceof ColombiaDark);
	}
	
	@Test
	public void testCreateDecaf() {
		Drink decaf = df.createDrink("Decaf");
		
		assertTrue(decaf instanceof Decaf);
	}
	
	@Test
	public void testCreateEspresso() {
		Drink espresso = df.createDrink("Espresso");
		
		assertTrue(espresso instanceof Espresso);
	}
	
	@Test
	public void testCreateLatte() {
		Drink latte = df.createDrink("Latte");
		
		assertTrue(latte instanceof Latte);
	}
	
	@Test
	public void testCreatePumpkinSpice() {
		Drink pumpkinSpice = df.createDrink("Pumpkin Spice");
		
		assertTrue(pumpkinSpice instanceof PumpkinSpice);
	}
	
	@Test
	public void testCreateSizes() {
		Drink decafS = df.createDrink("Small Decaf");
		Drink decafM = df.createDrink("Medium Decaf");
		Drink decafL = df.createDrink("Large Decaf");
		
		assertTrue(decafS instanceof Decaf);
		assertTrue(decafM instanceof Decaf);
		assertTrue(decafL instanceof Decaf);
	}
}

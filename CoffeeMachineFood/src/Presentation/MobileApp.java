package Presentation;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Data.ConcreteCPS;

public class MobileApp {
	
	private ConcreteCPS cps; 
	
	public MobileApp(ConcreteCPS cps) {
		this.cps = cps;
		System.out.println("Reading recipe in contrstor");
		readRecipe();
	}
	
	public void order(int orderNumber) {
		JSONParser parser = new JSONParser();
		JSONObject jsonRead = null;
		try {
			String fileToRead = "../order-input" + orderNumber + ".json";
			Object obj = parser.parse(new FileReader(fileToRead));
			jsonRead = (JSONObject)obj;
		} catch(Exception e) {
			e.printStackTrace();
		}
	   
		cps.processOrder(jsonRead, orderNumber);
	}
	
	public void readRecipe() {
		System.out.println("Reading the recipe");
		JSONParser parser = new JSONParser();
		JSONObject jsonRead = null;
		try {
			String fileToRead = "../recipe-input.json";
			Object obj = parser.parse(new FileReader("../maggot.json"));
			jsonRead = (JSONObject)obj;
		} catch(Exception e) {
			e.printStackTrace();
		}
	   
		cps.processRecipe(jsonRead);
	}
}

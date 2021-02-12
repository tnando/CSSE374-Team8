package Business;

import java.io.FileReader;

import org.json.simple.JSONArray;
//B0
//B2
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Business.Coffee.Drink.Drink;
import Business.Coffee.Machine.CoffeeMachine;
import Data.ConcreteCPS;

public class ConcreteController implements Controller {
	
	String controllerID;
	CoffeeMachine cm;
	ConcreteCPS cps;
	boolean isBusy;
	int orderNumber;
	
	public ConcreteController (String id, CoffeeMachine cm, ConcreteCPS cps) {
		this.controllerID = id;
		this.cm = cm;
		this.cps = cps;
	}
	
	public void makeCoffee(Drink drink, JSONArray condiments, int orderNumber) {
		isBusy = true;
		this.orderNumber = orderNumber;
		System.out.println(cm.makeCoffee(drink, condiments).getIngredients());
		isBusy = false;
		controllerResponse();
	}
	
	public String update() {
		if(isBusy) {
			return "-1";
		}
		else {
			return controllerID;
		}
	}
	
	//For testing purposes
	public void setIsBusy(boolean isBusy) {
		this.isBusy = isBusy;
	}
	
	public String getID() {
		return controllerID;
	}
	
	private void controllerResponse() {
		JSONParser parser = new JSONParser();
		JSONObject jsonRead = null;
		try {
			String fileToRead = "../controller-response" + this.orderNumber + ".json";
			Object obj = parser.parse(new FileReader(fileToRead));
			jsonRead = (JSONObject)obj;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		cps.processControllerResponse(jsonRead, this.orderNumber);
	}
	
}

package Presentation;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Data.ConcreteCPS;

public class MobileApp {
	
	private ConcreteCPS cps; 
	
	public MobileApp(ConcreteCPS cps) {
		this.cps = cps;
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
}

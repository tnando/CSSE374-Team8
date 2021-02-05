package Data;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import Business.Controller;
import Business.Coffee.DrinkFactory;

//B0
//B2
public class ConcreteCPS implements CPS{
	
	private ArrayList<Controller> controllers = new ArrayList<Controller>();
	private HashMap<Integer, String> orderMap = new HashMap<>();

	public void registerController(Controller o) {
		controllers.add(o);		
	}

	public void removeController(Controller o) {
		controllers.remove(o);
	}

	public String notifyControllers() {
		for(int i = 0; i < controllers.size(); i++) {
			String id = controllers.get(i).update();
			if(id.compareTo("-1") != 0) {
				return id;
			}
		}
		
		return "-1";
	}
	
	//For testing purposes
	public int getControllersLength() {
		return this.controllers.size();
	}
	
	//D1
	public void processOrder(JSONObject jsonOrder, int orderNumber) {
		
		System.out.println("Parsing the order:");
		JSONObject jsonWrite = new JSONObject();
		JSONObject command = new JSONObject();
		
		JSONObject order = (JSONObject)jsonOrder.get("order");
		JSONArray condimentJSON = (JSONArray)order.get("condiments");
		String condimentString;
		if (condimentJSON != null) {
			condimentString = condimentJSON.toString();
		} else {
			condimentString = "";
		}
				
		//adding the address
		JSONObject address = (JSONObject) order.get("address");
		String road = address.get("street").toString(); 
		String zip = address.get("ZIP").toString();
		System.out.println("road " + road + "ZIP " + zip); 
		
		
		Integer orderID =  Integer.parseInt(order.get("orderID").toString());
		Integer coffeeMachineID = null;

		String controller_id = notifyControllers();
		
		//D4
		//C6
		if(controller_id.compareTo("-1") == 0) {
			noControllerAvailable(orderNumber);
		} else {
		
			String coffeeMachine_id = controller_id;
			orderMap.put(orderNumber, controller_id);
			
			command.put("controller_id", controller_id);
			command.put("coffee_machine_id", coffeeMachine_id);
			command.put("order_id", orderID);
			command.put("drink_name", order.get("drink"));
			
			DrinkFactory df = new DrinkFactory();
			String ingredients = df.createDrink(order.get("drink").toString());
			
			command.put("ingredients", ingredients);
			System.out.println(ingredients);
			
			if(condimentString != null) {
				command.put("request_type", "Automated");
				command.put("options", condimentString);
			} else {
				command.put("request_type", "Simple");
			}
	        
			jsonWrite.put("command",command);
	       
			try {
				//D2
				FileWriter file;
				String fileToWrite = "../command_stream" + orderNumber + ".json";
				file = new FileWriter(fileToWrite);
			
				file.write(jsonWrite.toJSONString());
				file.close();
				
				for(int i = 0; i < controllers.size(); i++) {
					if(controllers.get(i).getID() == controller_id){
						//D3
						controllers.get(i).makeCoffee(condimentString, orderNumber);
						break;
					}
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void processControllerResponse(JSONObject jsonRead, int orderNumber) {
		System.out.println("Parsing the process control ");
		JSONObject jsonWrite = new JSONObject();
		JSONObject appResponse = new JSONObject();
		
		JSONObject response = (JSONObject)jsonRead.get("drinkresponse");
		Integer orderID = Integer.parseInt(response.get("orderID").toString());
		int status = Integer.parseInt(response.get("status").toString());
		Object errorCodeResponse = null;
		int errorCode;
		String errorDesc = null;
		if((errorCodeResponse= response.get("errorcode")) != null) {
			errorCode = Integer.parseInt(response.get("errorcode").toString());
			errorDesc = response.get("errordesc").toString();
		}
		
		String coffeeMachine_id = orderMap.get(orderNumber);
		
		
		appResponse.put("orderID", orderID);
		appResponse.put("coffee_machine_id", coffeeMachine_id);
		appResponse.put("status", status);
		if(status == 0) {
			appResponse.put("status-message", "Your coffee has been prepared with your desired options.");
		} else {
			appResponse.put("status-message", "Your coffee order has been cancelled.");
			appResponse.put("error-message", errorDesc);
		}
       
		jsonWrite.put("user-response",appResponse);
       
		try {
			FileWriter file;
			String fileToWrite = "../app_response" + orderNumber + ".json";
			file = new FileWriter(fileToWrite);
		
			file.write(jsonWrite.toJSONString());
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	public void noControllerAvailable(int orderNumber) {
		JSONObject jsonWrite = new JSONObject();
		JSONObject appResponse = new JSONObject();
		
		appResponse.put("orderID", orderNumber);
		appResponse.put("status", 1);
		appResponse.put("status-message", "Your coffee order has been cancelled.");
		appResponse.put("error-message", "There are no available machines");
		
		jsonWrite.put("user-response", appResponse);
		
		try {
			FileWriter file;
			String fileToWrite = "../app_response" + orderNumber + ".json";
			file = new FileWriter(fileToWrite);
		
			file.write(jsonWrite.toJSONString());
			file.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

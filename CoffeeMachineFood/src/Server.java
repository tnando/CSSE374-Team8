import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Server implements Runnable {
	
	private HashMap<Integer, Integer> orders = new HashMap<>();
	private Controller[] controllers = new Controller[3];
	private int orderNumber;
	
	public Server(Controller[] controllers, int orderNumber) {
		this.controllers = controllers;
		this.orderNumber = orderNumber;
	}
	
	@Override
	public void run() {
		JSONObject jsonRead = readOrder();
		sendToController(jsonRead);
		jsonRead = getResonseFromController();
		sendToApp(jsonRead);		
	}

	private JSONObject readOrder() {
		JSONParser parser = new JSONParser();
		JSONObject jsonRead = null;
		try {
			String fileToRead = "../order-input" + this.orderNumber + ".json";
			Object obj = parser.parse(new FileReader(fileToRead));
			jsonRead = (JSONObject)obj;
		} catch(Exception e) {
			e.printStackTrace();
		}
	   
		return jsonRead;
	}
   
	@SuppressWarnings("unchecked")
	private void sendToController(JSONObject jsonRead) {
		JSONObject jsonWrite = new JSONObject();
		JSONObject command = new JSONObject();
		
		JSONObject order = (JSONObject)jsonRead.get("order");
		Object condiments = order.get("condiments");
		Integer orderID =  Integer.parseInt(order.get("orderID").toString());
		Integer coffeeMachineID = null;
		int controller_id = -1;

		for(int i = 0; i < 3; i++) {
			if(controllers[i].getIsBusy() == false) {
				controller_id = i + 1;
				coffeeMachineID = i + 1;
				controllers[i].makeCoffee();
				break;
			}
		}
		
		orders.put(orderID,coffeeMachineID);
		
		command.put("controller_id", controller_id);
		command.put("coffee_machine_id", coffeeMachineID);
		command.put("order_id", orderID);
		command.put("drink_name", order.get("drink"));
		if(condiments != null) {
			command.put("request_type", "Automated");
			command.put("options", condiments);
		} else {
			command.put("request_type", "Simple");
		}
        
		jsonWrite.put("command",command);
       
		try {
			FileWriter file;
			String fileToWrite = "../command_stream" + this.orderNumber + ".json";
			file = new FileWriter(fileToWrite);
		
			file.write(jsonWrite.toJSONString());
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
	private JSONObject getResonseFromController() {
		JSONParser parser = new JSONParser();
		JSONObject jsonRead = null;
		try {
			String fileToRead = "../controller-response" + this.orderNumber + ".json";
			Object obj = parser.parse(new FileReader(fileToRead));
			jsonRead = (JSONObject)obj;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return jsonRead;
	}
	
	@SuppressWarnings("unchecked")
	private void sendToApp(JSONObject jsonRead) {
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
		
		int coffeeMachineID = orders.get(orderID);
		
		appResponse.put("orderID", orderID);
		appResponse.put("coffee_machine_id", coffeeMachineID);
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
			String fileToWrite = "../app_response" + this.orderNumber + ".json";
			file = new FileWriter(fileToWrite);
		
			file.write(jsonWrite.toJSONString());
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
}


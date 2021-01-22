import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Main {
	
	private static HashMap<Integer, Integer> orders = new HashMap<>();
	
	public static void main(String[] args) {
	   
	   start();   
      
	}
   
	private static void start() {
		JSONObject jsonRead = readOrder();
		sendToController(jsonRead);
		jsonRead = getResonseFromController();
		sendToApp(jsonRead);
	}

	private static JSONObject readOrder() {
		JSONParser parser = new JSONParser();
		JSONObject jsonRead = null;
		try {
			Object obj = parser.parse(new FileReader("../order-input1.json"));
			jsonRead = (JSONObject)obj;
		} catch(Exception e) {
			e.printStackTrace();
		}
	   
		return jsonRead;
	}
   
	@SuppressWarnings("unchecked")
	private static void sendToController(JSONObject jsonRead) {
		JSONObject jsonWrite = new JSONObject();
		JSONObject command = new JSONObject();
		
		JSONObject order = (JSONObject)jsonRead.get("order");
		Object condiments = order.get("condiments");
		System.out.println(order.get("orderID").getClass());
		Integer orderID =  Integer.parseInt(order.get("orderID").toString());
		Integer coffeeMachineID = 1;
		
		orders.put(orderID,coffeeMachineID);
		
		command.put("controller_id", 2);
		command.put("coffee_macine_id", coffeeMachineID);
		command.put("order_id", orderID);
		command.put("drink_name", order.get("drink"));
		if(condiments != null) {
			command.put("request_type", "Automated");
			command.put("options", condiments);
		} else {
			command.put("request_type", "Simple");
		}
       
		jsonWrite.put("command",command);
       
		System.out.println(jsonWrite.get("command"));
       
		try {
			FileWriter file;
			file = new FileWriter("../command_stream1.json");
		
			file.write(jsonWrite.toJSONString());
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
	private static JSONObject getResonseFromController() {
		JSONParser parser = new JSONParser();
		JSONObject jsonRead = null;
		try {
			Object obj = parser.parse(new FileReader("../controller-response1.json"));
			jsonRead = (JSONObject)obj;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return jsonRead;
	}
	
	@SuppressWarnings("unchecked")
	private static void sendToApp(JSONObject jsonRead) {
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
		
		System.out.println(orderID);
		int coffeeMachineID = orders.get(orderID);
		
		appResponse.put("orderID", orderID);
		appResponse.put("coffee_macine_id", coffeeMachineID);
		appResponse.put("status", status);
		if(status == 0) {
			appResponse.put("status-message", "Your coffee has been prepared with your desired options.");
		} else {
			appResponse.put("status-message", "Your coffee order has been cancelled.");
			appResponse.put("error-message", errorDesc);
		}
       
		jsonWrite.put("user-response",appResponse);
       
		System.out.println(jsonWrite.get("command"));
       
		try {
			FileWriter file;
			file = new FileWriter("../app_response1.json");
		
			file.write(jsonWrite.toJSONString());
			file.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
   
}

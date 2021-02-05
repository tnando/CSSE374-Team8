package Data;

import java.io.FileReader;
import java.util.Iterator;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonParsesPractice{
	static JSONParser parser = new JSONParser();
	static JSONObject jsonRead = null;
	
	
	public static void main (String [] args) {
		try {
			String fileToRead = "../command_stream" + ".json";
			Object obj = parser.parse(new FileReader(fileToRead));
			jsonRead = (JSONObject)obj;
			
			int controllerId = Integer.parseInt(jsonRead.get("controller_id").toString()); 
			int coffee_machine_id = Integer.parseInt(jsonRead.get("coffee_machine_id").toString()); 
			int orderID = (int)jsonRead.get("orderID");
			String drinkName = jsonRead.get("DrinkName").toString();
			String requestType=jsonRead.get("Requesttype").toString();
			JSONArray options =  jsonRead.getJSONArray("Options");
			for (Object o : lineItems) {
		        JSONObject jsonLineItem = (JSONObject) o;
		        String key = jsonLineItem.getString("key");
		        String value = jsonLineItem.getString("value");
		        ...
		    }
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	
	
	} 
}

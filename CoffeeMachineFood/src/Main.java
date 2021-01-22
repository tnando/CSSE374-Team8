import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

import org.json.simple.*;
import org.json.simple.parser.*;

public class Main {
   public static void main(String[] args) {
	   
	   start();   
      
   }
   
   public static void start() {
	   JSONObject jsonRead = readOrder();
	   sendToController(jsonRead);
   }
   
   public static JSONObject readOrder() {
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
public static void sendToController(JSONObject jsonRead) {
	   JSONObject jsonWrite = new JSONObject();
       JSONObject command = new JSONObject();
       command.put("controller_id", 2);
       command.put("coffee_macine_id", 1);
       command.put("order_id", ((JSONObject)jsonRead.get("order")).get("orderID"));
       command.put("drink_name", ((JSONObject)jsonRead.get("order")).get("drink"));
       Object condiments =((JSONObject)jsonRead.get("order")).get("condiments");
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
   
   
}

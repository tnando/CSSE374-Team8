package Data;

import org.json.simple.JSONObject;

import Business.Controller;

public interface CPS {
	
	public void registerController(Controller o);
	public void removeController(Controller o);
	public String notifyControllers();
	public void processOrder(JSONObject jsonOrder, int orderNumber);
}

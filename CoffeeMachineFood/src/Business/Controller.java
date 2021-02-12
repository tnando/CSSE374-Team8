package Business;

import org.json.simple.JSONArray;

import Business.Coffee.Drink.Drink;

public interface Controller {
	
	//B0
	public String update();
	public void makeCoffee(Drink drink, JSONArray condiments, int orderNumber);
	public String getID();
	public void setIsBusy(boolean isBusy);

}

package Business.Coffee.Condiment;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Business.Coffee.Drink.Drink;
import Business.Coffee.Drink.IDrink;
import Business.Coffee.Ingredients.Cream;
import Business.Coffee.Ingredients.SpiceHazelnut;
import Business.Coffee.Ingredients.SpiceSugar;

//B0
public abstract class CondimentBehavior {
	public IDrink addCondiments(IDrink drink, JSONArray condiments) {
		if(condiments != null) {
			for(int i = 0; i < condiments.size(); i++ ){
				int quantity = Integer.parseInt(((JSONObject)condiments.get(i)).get("qty").toString());
				String cond = ((JSONObject)condiments.get(i)).get("name").toString();
				for(int j = 0; j < quantity; j++) {
					if(cond.equals("Sugar")) {
						drink = (IDrink)(new SpiceSugar(drink));
					} else if(cond.equals("Cream")) {
						drink = (IDrink)(new Cream(drink));
					} else if(cond.equals("Hazelnut")) {
						drink = (IDrink)(new SpiceHazelnut(drink));
					}
				}
			}
		}
		
		return drink;
	}
	public abstract String whoAdded();
	
}

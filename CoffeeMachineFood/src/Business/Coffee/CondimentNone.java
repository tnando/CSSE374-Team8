package Business.Coffee;

//B0
public class CondimentNone implements CondimentBehavior {
	
	public String addCondiments(String[] condiments) {
		String toReturn = "";
		if(condiments.length > 0){
			toReturn += "Condiments must be added by the barista.\n";
			toReturn += "Condiments to Add: \n";
			for(int i = 0; i < condiments.length; i++) {
				toReturn += "   - " + condiments[i] + "\n";
			}
		}
		
		return toReturn;
	}
}

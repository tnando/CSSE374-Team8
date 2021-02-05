package Business.Coffee.Condiment;

//B0
public class CondimentAdd implements CondimentBehavior {
	
	public String addCondiments(String[] condiments) {
		String toReturn = "";
		if(condiments.length > 0) {
			toReturn += "Adding condiments...\n";
			for( int i = 0; i < condiments.length; i++ ){
				toReturn += "Added " + condiments[i] + "\n";
			}
		}
		
		return toReturn;
	}

}

package Business.Coffee;

public class CondimentAdd implements CondimentBehavior {
	
	public void addCondiments(String[] condiments) {
		if(condiments.length > 0) {
			System.out.println("Adding condiments...");
			for( int i = 0; i < condiments.length; i++ ){
				System.out.println("Added " + condiments[i]);
			}
		}
	}

}

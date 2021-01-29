package Business.Coffee;

public class CondimentNone implements CondimentBehavior {
	
	public void addCondiments(String[] condiments) {
		if(condiments.length > 0){
			System.out.println("Condiments must be added by the barista.");
			System.out.println("Condiments to Add: ");
			for(int i = 0; i < condiments.length; i++) {
				System.out.println("   - " + condiments[i]);
			}
		}
	}
}

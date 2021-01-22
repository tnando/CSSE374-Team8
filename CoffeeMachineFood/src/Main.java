
public class Main {

	private static Controller[] controllers = new Controller[3];
	
	public static void main(String[] args) {
		
		for(int i = 0; i < 3; i++) {
			controllers[i] = new Controller();
		}
		   
		for(int i = 0; i < 3; i++) {		   
			Thread thread = new Thread(new Server(controllers, i+1));
			thread.start();
		}
      
	}
}

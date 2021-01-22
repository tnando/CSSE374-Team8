import java.util.concurrent.TimeUnit;

public class Controller {
	private boolean isBusy;
	
	public Controller() {
		isBusy = false;
	}
	
	public void makeCoffee() {
		isBusy = true;
		try {
			TimeUnit.SECONDS.sleep(2);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		isBusy = false;
	}
	
	public boolean getIsBusy() {
		return isBusy;
	}
}

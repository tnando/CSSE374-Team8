package Business;

public interface Controller {
	
	public String update();
	public void makeCoffee(String[] condiments, int orderNumber);
	public String getID();
	public void setIsBusy(boolean isBusy);

}

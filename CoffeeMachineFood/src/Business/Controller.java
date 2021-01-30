package Business;

public interface Controller {
	
	//B0
	public String update();
	public void makeCoffee(String[] condiments, int orderNumber);
	public String getID();
	public void setIsBusy(boolean isBusy);

}

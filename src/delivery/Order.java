package delivery;

public class Order{
	private String dishNames[];
	private int quantities[]; 
	private String customerName,restaurantName;
	private int deliveryTime;
	private int deliveryDistance,number;
	private boolean assigned;
	
	public Order(String[] dishNames, int[] quantities, String customerName, String restaurantName,int deliveryTime,
			int deliveryDistance, int number ) {
		this.dishNames = dishNames;
		this.quantities = quantities;
		this.customerName = customerName;
		this.restaurantName = restaurantName;
		this.deliveryTime = deliveryTime;
		this.deliveryDistance = deliveryDistance;
		this.assigned=false;
		this.number=number;
		
	}

	public boolean inRange(int dTime, int maxDistance) {
		if(deliveryTime<=dTime && deliveryDistance<=maxDistance)
			return true;
		return false;
	}

	public boolean isAssigned() {
		return assigned;
	}

	public void setAssigned(boolean assigned) {
		this.assigned = assigned;
	}

	public int getNumber() {
		return number;
	}
	
	
	
	
}

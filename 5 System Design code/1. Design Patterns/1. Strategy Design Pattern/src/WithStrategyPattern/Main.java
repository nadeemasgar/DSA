package WithStrategyPattern;

public class Main {

	public static void main(String[] args) {
		
		Vehicle vehicle = new SportsVehicle();
		vehicle.drive();
		
		Vehicle vehicle2 = new GoodsVehicle();
		vehicle2.drive();
	}

}

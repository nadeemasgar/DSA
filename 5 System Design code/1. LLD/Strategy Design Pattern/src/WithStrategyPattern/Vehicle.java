package WithStrategyPattern;

import WithStrategyPattern.Strategy.DriveStrategy;

public class Vehicle {
	DriveStrategy driveObject; // interface ka object banaya
	
	// this is know as constructor injection
	Vehicle(DriveStrategy driveObj) {
		this.driveObject = driveObj;
	}
	
	public void drive() {
		driveObject.drive();
	}
}

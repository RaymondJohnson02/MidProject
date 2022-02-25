package VehiclePackage;

public class Car extends Vehicle{
	private int entertainmentSystem;
	public Car(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel, String type, int entertainmentSystem) {
		super(brand, name, licenseNumber, topSpeed, gasCap, wheel, type);
		this.entertainmentSystem = entertainmentSystem;
	}
	
	public void TurnOn() {
		System.out.println("Turning on entertainment system...");
		if(getType().equals("Supercar")) {
			System.out.println("Boosting!");
		}
	}
	
	public int getEntertainmentSystem() {
		return this.entertainmentSystem;
	}
	
}

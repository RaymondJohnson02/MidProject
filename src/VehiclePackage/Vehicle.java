package VehiclePackage;

public abstract class Vehicle {
	private String brand;
	private String name;
	private String licenseNumber;
	private int topSpeed;
	private int gasCap;
	private int wheel;
	private String type;
	
	public Vehicle(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel, String type) {
		this.brand = brand;
		this.name = name;
		this.licenseNumber = licenseNumber;
		this.topSpeed = topSpeed;
		this.gasCap = gasCap;
		this.wheel = wheel;
		this.type = type;
	}
	
	public abstract void TurnOn();
	
	public String VehicleType() {
		if(this.wheel>=4) {
			return "Car";
		}
		return "Motorcycle";
	}
	
	public String getBrand() {
		return this.brand;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getLicense() {
		return this.licenseNumber;
	}
	
	public int getTopSpeed() {
		return this.topSpeed;
	}
	
	public int getGasCap() {
		return this.gasCap;
	}
	
	public int getWheel() {
		return this.wheel;
	}
	
	public String getType() {
		return this.type;
	}
	
}
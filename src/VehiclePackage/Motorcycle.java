
package VehiclePackage;
import java.util.Scanner;

public class Motorcycle extends Vehicle{
	private int helm;
	public Motorcycle(String brand, String name, String licenseNumber, int topSpeed, int gasCap, int wheel, String type, int helm) {
		super(brand, name, licenseNumber, topSpeed, gasCap, wheel, type);
		this.helm = helm;
	}
	
	public void TurnOn() {
		System.out.println(getName()+" is standing!");
		Scanner in = new Scanner(System.in);
		System.out.print("Please input helm price: ");
		int price = in.nextInt();
		price*=this.helm;
		System.out.println("Price : "+price);
	}
	
	public int getHelm() {
		return this.helm;
	}
	
	
}

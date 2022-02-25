import VehiclePackage.Car;
import VehiclePackage.Motorcycle;
import VehiclePackage.Vehicle;
import java.util.*;

public class main {
	public static void main(String arg[]) {
		ArrayList<Vehicle> VehicleList = new ArrayList<Vehicle>();
		int choice = -1;
		do {
			clear();
			System.out.println("Welcome please select an action:");
			System.out.println("1. Input a vehicle");
			System.out.println("2. View");
			System.out.println("3. Exit");
			System.out.print(">>");
			Scanner sc = new Scanner(System.in);
			choice = sc.nextInt();
			switch(choice) {
				case 1:
					clear();
					VehicleList.add(insert());
					break;
				case 2:
					clear();
					view(VehicleList);
					break;
			}
		}while(choice!=3);
	}
	
	static void clear() {
		for(int i=0; i<20; i++)System.out.println();
	}
	
	static void view(ArrayList<Vehicle> VehicleList) {
		Scanner in = new Scanner(System.in);
		System.out.println("|-----|---------------|---------------|");
		System.out.println("|No   |Type           |Name           |");
		System.out.println("|-----|---------------|---------------|");
		
		int stock = VehicleList.size();
		for(int i=0; i<stock; i++)
		{
			System.out.printf("|%-5d|%-15s|%-15s|\n",i+1,VehicleList.get(i).VehicleType(),VehicleList.get(i).getName());
		}
		System.out.println("|-----|---------------|---------------|");
		System.out.println("|-----|---------------|---------------|");
		int select = -1;
		System.out.print("Pick a vehicle number to test drive[enter '0' to exit]: ");
		select = in.nextInt();
		if(select==0) {
			System.out.println("ENTER to return");
			in.nextLine();
			in.nextLine();
			return;
		}else if(select>stock) {
			System.out.println("Invalid vehicle number");
			System.out.println("ENTER to return");
			in.nextLine();
			in.nextLine();
			return;
		}else {
			int viewIndex = select-1;
			Vehicle viewThis = VehicleList.get(viewIndex);
			
			if(viewThis.VehicleType().equals("Car")) {
				Car viewThisCar = (Car)viewThis;
				
				System.out.println("Brand : "+viewThisCar.getBrand());
				System.out.println("Name : "+viewThisCar.getName());
				System.out.println("License Plate : "+viewThisCar.getLicense());
				System.out.println("Type : "+viewThisCar.getType());
				System.out.println("Gas Capacity : "+viewThisCar.getGasCap());
				System.out.println("Top Speed: "+viewThisCar.getTopSpeed());
				System.out.println("Wheel(s) : "+ viewThisCar.getWheel());
				System.out.println("Entertainment System : "+viewThisCar.getEntertainmentSystem());
				viewThisCar.TurnOn();
			}else {
				Motorcycle viewThisMotorcycle = (Motorcycle)viewThis;
				
				System.out.println("Brand : "+viewThisMotorcycle.getBrand());
				System.out.println("Name : "+viewThisMotorcycle.getName());
				System.out.println("License Plate : "+viewThisMotorcycle.getLicense());
				System.out.println("Type : "+viewThisMotorcycle.getType());
				System.out.println("Gas Capacity : "+viewThisMotorcycle.getGasCap());
				System.out.println("Top Speed: "+viewThisMotorcycle.getTopSpeed());
				System.out.println("Wheel(s) : "+ viewThisMotorcycle.getWheel());
				System.out.println("Helm : "+viewThisMotorcycle.getHelm());
				viewThisMotorcycle.TurnOn();
			}
			System.out.println("Enter to return");
			in.nextLine();
		}
		in.nextLine();
		return;
	}
	
	static Vehicle insert() {
		Scanner in = new Scanner(System.in);
		
		String Type;
		do {
			System.out.print("Input type [Car | Motorcycle]: ");
			Type = in.nextLine();
		}while(!validType(Type));
		
		String brand;
		do {
			System.out.print("Input brand [>=5]: ");
			brand = in.nextLine();
		}while(!validBrand(brand));
		
		String name;
		do {
			System.out.print("Input name [>=5]: ");
			name = in.nextLine();
		}while(!validName(name));
		
		String license;
		do {
			System.out.print("Input license: ");
			license = in.nextLine();
		}while(!validLicense(license));
		
		int topSpeed;
		do {
			System.out.print("Input top speed [100 <= topspeed <= 250]: ");
			topSpeed = in.nextInt();
		}while(!validTopSpeed(topSpeed));
		
		int gasCap;
		do {
			System.out.print("Input gas capacity [30 <= gasCap <= 60]: ");
			gasCap = in.nextInt();
		}while(!validGasCap(gasCap));
		
		int wheel;
		do {
			if(Type.equals("Car")) {
				System.out.print("Input wheel [4 <= wheel <= 6]: ");
			}else {
				System.out.print("Input wheel [2 <= wheel <= 3]: ");
			}
			wheel = in.nextInt();
			in.nextLine();
		}while(!validWheel(wheel,Type));
		
		String Type2;
		do {
			if(Type.equals("Car")) {
				System.out.print("Input type [SUV | Supercar | Minivan]: ");
			}else {
				System.out.print("Input type [Automatic | Manual]: ");
			}
			Type2 = in.nextLine();
		}while(!validType2(Type2, Type));
		
		if(Type.equals("Car")) {
			int ESA;
			do {
				System.out.print("Input entertainment system amount [>=1]: ");
				ESA = in.nextInt();
			}while(!validESA(ESA));
			Vehicle newCar = new Car(brand,name,license,topSpeed,gasCap,wheel,Type2,ESA);
			System.out.println("ENTER to return");
			in.nextLine();
			in.nextLine();
			return newCar;
			
		}else {
			int helm;
			do {
				System.out.print("Input helm [>=1]: ");
				helm = in.nextInt();
			}while(!validHelm(helm));
			Vehicle newMotorcycle = new Motorcycle(brand,name,license,topSpeed,gasCap,wheel,Type2,helm);
			System.out.println("ENTER to return");
			in.nextLine();
			in.nextLine();
			return newMotorcycle;
		}
	}
	
	static boolean validType(String Type) {
		return Type.equals("Car") || Type.equals("Motorcycle");
	}
	
	static boolean validBrand(String brand) {
		return brand.length()>=5;
	}
	
	static boolean validName(String name) {
		return name.length()>=5;
	}
	
	static boolean validLicense(String license) {
		int len = license.length();
		if(len<5) return false;
		if(license.charAt(len-1)<65 || license.charAt(len-1)>90) return false;
		
		int i=0;
		if(license.charAt(i)<65 || license.charAt(i)>90) return false;
		i++;
		if(license.charAt(i)!=' ') return false;
		i++;
		
		int numberDigit = 0;
		if(license.charAt(i)<48 || license.charAt(i)>57) {
			return false;
		}else {
			while(license.charAt(i)>=48 && license.charAt(i)<=57) {
				numberDigit++;
				i++;
			}
			if(numberDigit>4) return false;
		}
		
		if(license.charAt(i)!=' ') return false;
		i++;
		
		int numberCapitalChar = 0;
		if(license.charAt(i)<65 || license.charAt(i)>90) {
			return false;
		}
		else {
			while(i!=len && (license.charAt(i)>=65 && license.charAt(i)<=90)) {
				numberCapitalChar++;
				i++;
			}
			if(numberCapitalChar>3) return false;
		}
		return i==len;
	}
	
	static boolean validTopSpeed(int topSpeed) {
		return topSpeed>=100 && topSpeed<=250;
	}
	
	static boolean validGasCap(int gasCap) {
		return gasCap>=30 && gasCap<=60;
	}
	
	static boolean validWheel(int wheel, String Type) {
		if(Type.equals("Car")) {
			return wheel>=4 && wheel<=6;
		}
		return wheel>=2 && wheel<=3;
	}
	
	static boolean validType2(String Type2, String Type) {
		if(Type.equals("Car")) {
			return Type2.equals("SUV") || Type2.equals("Supercar") || Type2.equals("Minivan");
		}else {
			return Type2.equals("Automatic") || Type2.equals("Manual");
		}
	}
	
	static boolean validESA(int ESA) {
		return ESA>=1;
	}
	
	static boolean validHelm(int helm) {
		return helm>=1;
	}
}

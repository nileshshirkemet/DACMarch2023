import hospital.*;

class Program{
	public static void main(String[] args){
		Patient p = new Patient(101, 1, 5);
		InHousePatient  ip = new InHousePatient(102, 1, 5, 10.0f);
		System.out.printf("Total Bill for Patient is %f%n", p.getBill());
		System.out.printf("Total Bill for InHouse Patient is %f%n", ip.getBill());
	}
}

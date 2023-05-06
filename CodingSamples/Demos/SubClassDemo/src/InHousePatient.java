package hospital;

public class InHousePatient extends Patient{
	private float discount;

	public InHousePatient(int i, int b, int d, float dis){
		super(i, b, d);
		discount = dis;
	}
	
	public float getDiscount(){
		return discount;
	}
	public void setDiscount(float dis){
		discount = dis;
	}

	public double getBill(){
		double bill = super.getBill();
		bill = bill * (1 - discount / 100);

		return bill;
	}

}

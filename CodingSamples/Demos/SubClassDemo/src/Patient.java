package hospital;

public class Patient{
	protected int id;
	protected int bedType;
	protected int days;

    public Patient(int ii, int bb, int dd){
		id = ii;
		bedType = bb;
		days = dd;
	}

    public int getId(){
		return id;
	}
	
	public void setBedType(int type){
		bedType = type;
	}

	public int getBedType(){
		return bedType;
	}
	
	public void setDays(int d){
		days = d;
	}

	public int getDays(){
		return days;
	}

	protected double getPricePerDay(){
		if (bedType == 1) 
			return 500;
		else if (bedType == 2)
			return 350;
		else if (bedType == 3)
			return 200;
		else
			return 400;
	}

	public double getBill(){
		double amount = 0;
		amount = days * getPricePerDay();
		return amount;
	}
}









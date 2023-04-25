class Investment {

	//instance fields - values will be separately stored in each instance
	private double installment;
	private int years;
	private boolean risk;

	//constructor - initializes new instance, if no constructor is explictly
	//defined in a class a parameterless constructor is implicitly define
	public Investment(double amount, int period) {
		installment = amount;
		years = period;
		risk = false;
	}

	//instance method - can only be called on object using . operator,
	//receives a hidden 'this' argument which refers to the object
	//on (left side of . operator) which this method is called 
	public void allowRisk(boolean yes) {
		risk = yes; //this.risk = yes
	}

	public double totalAmount() {
		return installment * years;
	}

	public double futureValue() {
		float i = risk ? 0.11f : 0.06f;
		return (installment / i) * (Math.pow(1 + i, years) - 1);
	}

}


enum RiskLevel {
	NONE, LOW, HIGH;
}

class Investment {

	private double installment;
	private int years;
	private RiskLevel risk;

	public Investment(double amount, int period) {
		installment = amount;
		years = period;
		risk = RiskLevel.NONE;
	}

	public void allowRisk(boolean yes) {
		risk = yes ? RiskLevel.LOW : RiskLevel.NONE;
	}

	//method overloading - defining multiple methods in a given class
	//with same name but different list of parameter types
	public void allowRisk(RiskLevel level) {
		risk = level;
	}

	public double totalAmount() {
		return installment * years;
	}

	public double futureValue() {
		float i;
		switch(risk){
			case LOW:
				i = 0.11f;
				break;
			case HIGH:
				i = 0.15f;
				break;
			default:
				i = 0.06f;
		}
		return (installment / i) * (Math.pow(1 + i, years) - 1);
	}

}


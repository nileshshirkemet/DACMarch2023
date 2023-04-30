//functional interface
interface InterestRate {
	float forPeriod(int count);
	//default float forAmount(double money) { return 9.5f; } 
}

class Investment {

	private final double installment;
	private final int years;

	public Investment(double installment, int years) {
		this.installment = installment;
		this.years = years;
	}

	public double installment() { return installment; }

	public int years() { return years; }

	public double futureValue(InterestRate rate) {
		float i = rate.forPeriod(years) / 100;
		return (installment / i) * (Math.pow(1 + i, years) - 1);
	}
}


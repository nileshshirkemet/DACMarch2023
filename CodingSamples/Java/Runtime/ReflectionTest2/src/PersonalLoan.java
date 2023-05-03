package finance;


public class PersonalLoan {

	@MaxDuration(6)
	public double common(double amount, int period) {
		return 11 + 0.5 * (period / 3);
	}

	public double employee(double amount, int period) {
		return common(amount, period) - 5;
	}
}


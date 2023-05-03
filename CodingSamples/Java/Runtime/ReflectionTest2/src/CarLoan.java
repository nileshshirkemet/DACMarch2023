package finance;

public class CarLoan extends PersonalLoan {

	@Override
	public double common(double amount, int period) {
		return 12 + amount / 500000;
	}
}


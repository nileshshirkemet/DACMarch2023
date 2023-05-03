package finance;

public class HomeLoan {

	public double common(double amount, int period) {
		return amount < 5000000 ? 9 : 8.5;
	}

	public double woman(double amount, int period) {
		return common(amount, period) - 1;
	}

	@MaxDuration(value=12)
	public double welfare(double amount, int period) {
		return 0.5 * common(amount, period);
	}
}


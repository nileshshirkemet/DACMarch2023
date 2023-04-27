package taxation;

public class Supervisor implements TaxPayer {

	public int span;

	public Supervisor(int count) {
		span = count;
	}

	public double annualIncome() {
		return 300000 + 10000 * span;
	}
}


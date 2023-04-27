package taxation;

public interface TaxPayer {

	double annualIncome();
	
	default double incomeTax() {
		double extra = annualIncome() - 120000;
		return extra > 0 ? 0.15 * extra : 0;
	}
}


class Program {

	private static void advise(Investment inv) {
		inv.allowRisk(inv.totalAmount() < 500000);
	}

	public static void main(String[] args) {
		double p = Double.parseDouble(args[0]);
		int n = Integer.parseInt(args[1]);
		Investment my = new Investment(p, n);
		System.out.printf("Future value of no risk investment = %.2f%n", my.futureValue());
		my.allowRisk(true);
		System.out.printf("Future value of low risk investment = %.2f%n", my.futureValue());
		advise(my); //static member (main) can only refer to static members of its class
		System.out.printf("Future value of smart investment = %.2f%n", my.futureValue());
		my.allowRisk(RiskLevel.HIGH);
		System.out.printf("Future value of high risk investment = %.2f%n", my.futureValue());
	}
}


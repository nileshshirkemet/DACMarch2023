class Program {

	public static void main(String[] args) {
		double p = Double.parseDouble(args[0]);
		int n = Integer.parseInt(args[1]);
		System.out.printf("Future value of no risk investment = %.2f%n", Investment.futureValue(p, n, false));
		System.out.printf("Future value of low risk investment = %.2f%n", Investment.futureValue(p, n, true));
	}
}


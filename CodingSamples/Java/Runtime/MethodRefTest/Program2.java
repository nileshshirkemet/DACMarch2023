class Program {
	
	private static float safeScheme(int n) {
		return n <= 3 ? 6 : 7;
	}

	public static void main(String[] args) {
		double p = Double.parseDouble(args[0]);
		int n = Integer.parseInt(args[1]);
		Investment my = new Investment(p, n);
		//passing method reference in place of functional interface
		System.out.printf("Future value of safe investment = %.2f%n", my.futureValue(Program::safeScheme));
		//passing lambda expression (method reference to an anonymous method)
		System.out.printf("Future value of risky investment = %.2f%n", my.futureValue(y -> 10 + 0.5f * y));
	}
}


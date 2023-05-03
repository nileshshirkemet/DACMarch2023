class Program {

	public static void main(String[] args) throws Exception {
		double p = Double.parseDouble(args[0]);
		var c = Class.forName("finance." + args[1] + "Loan");
		Object policy = c.getConstructor().newInstance();
		var scheme = c.getMethod(args[2], double.class, int.class);
		int m = 10;
		for(int n = 1; n <= m; ++n) {
			double r = (double)scheme.invoke(policy, p, n); //late-binding
			double i = r / 1200;
			double e = p * i / (1 - Math.pow(1 + i, -12 * n));
			System.out.printf("%-6d%16.2f%n", n, e);
		}
	}
}


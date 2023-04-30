class Program {

	static class SafeScheme implements InterestRate {
		public float forPeriod(int count) {
			return count <= 3 ? 6.0f : 7.0f;
		}
	}

	public static void main(String[] args) {
		double p = Double.parseDouble(args[0]);
		int n = Integer.parseInt(args[1]);
		Investment my = new Investment(p, n);
		System.out.printf("Future value of safe investment = %.2f%n", my.futureValue(new SafeScheme()));
		System.out.printf("Future value of risky investment = %.2f%n", my.futureValue(new InterestRate(){
			public float forPeriod(int count) {
				return 10 + 0.5f * count;
			}
		}));
	}
}


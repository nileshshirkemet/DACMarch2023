class Program {

	public static void main(String[] args) {
		System.out.printf("Average of two values: %.3f\n", Statistics.average(43.2, 56.1));
		System.out.printf("Average of three values: %.3f\n", Statistics.average(43.2, 56.1, 32.4));
		System.out.printf("Average of five values: %.3f\n", Statistics.average(43.2, 56.1, 32.4, 67.8, 25.9)); // Statistics.average(43.2, 56.1, new double[]{32.4, 67.8, 25.9})
		if(args.length > 1){
			double x = Double.parseDouble(args[0]);
			double y = Double.parseDouble(args[1]);
			DoubleRef d = new DoubleRef();
			double a = Statistics.averageWithDeviation(x, y, d);
			System.out.printf("Average of given values is %.3f with a deviation of %.2f%n", a, d.value);
		}
	}
}



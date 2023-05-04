class LegacyQE {

	private double first, second, third;

	public LegacyQE(double a, double b, double c) {
		first = a;
		second = b;
		third = c;
	}

	public native double[] realRoots();

	static {
		System.loadLibrary("legacyqe");
	}

}


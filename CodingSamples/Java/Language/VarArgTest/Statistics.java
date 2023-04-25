class DoubleRef {
	public double value;
}

class Statistics {

	/*
	public static double average(double first, double second) {
		return (first + second) / 2;
	}

	public static double average(double first, double second, double third) {
		return (first + second + third) / 3;
	}
	*/

	public static double average(double first, double second, double... other)
	{
		double total = first + second;
		for(double item : other){
			total += item;
		}
		return total / (2 + other.length);
	}

	public static double averageWithDeviation(double first, double second, DoubleRef delta) {
		delta.value = first > second ? (first - second) / 2 : (second - first) / 2;
		return average(first, second);
	}
}


class Program {
	
	//declaring generic select method with type parameter T
	private static <T> T select(int choice, T first, T second) {
if((choice % 2) == 1)
			return first;
		return second;
	}

	//using bounded type parameter
	private static <T extends Comparable<T>> T select(T first, T second) {
		if(first.compareTo(second) > 0)
			return first;
		return second;
	}

	public static void main(String[] args) {
		if(args.length > 0){
			int s = Integer.parseInt(args[0]);
			String ss = select(s, "Monday", "Friday");
			System.out.printf("Selected String = %s%n", ss);
			double sd = select(s, 23.4, 43.2);
			System.out.printf("Selected double = %s%n", sd);
			//int si = select(s, "abcd", 1234);
		}else{
			String ss = select("Monday", "Friday");
			System.out.printf("Selected String = %s%n", ss);
			double sd = select(23.4, 43.2);
			System.out.printf("Selected double = %s%n", sd);
			Interval si = select(new Interval(5, 40), new Interval(3, 20)); 
			System.out.printf("Selected Interval = %s%n", si);
		}
	}
}


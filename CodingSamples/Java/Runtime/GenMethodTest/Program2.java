class Program {
	
	private static Object select(int choice, Object first, Object second) {
		if((choice % 2) == 1)
			return first;
		return second;
	}
	
	public static void main(String[] args) {
		if(args.length > 0){
			int s = Integer.parseInt(args[0]);
			String ss = (String)select(s, "Monday", "Friday");
			System.out.printf("Selected String = %s%n", ss);
			//Auto Boxing - A primitive-type is implicitly converted to a 
			//reference type by enclosing its value within an instance of 
			//its wrapper class
			double sd = (double)select(s, 23.4, 43.2);
			System.out.printf("Selected double = %s%n", sd);
			int si = (int)select(s, "abcd", 1234);
		}
	}
}


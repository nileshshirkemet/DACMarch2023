class Program {
	
	public static void main(String[] args) {
		if(args[0].equals("gcd")){
			long p = Long.parseLong(args[1]);
			long q = Long.parseLong(args[2]);
			System.out.println(Computation.gcdOf(p, q));
		}
	}
}


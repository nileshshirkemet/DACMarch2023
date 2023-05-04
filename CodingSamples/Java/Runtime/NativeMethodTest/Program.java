import java.util.*;

class Program {
	
	public static void main(String[] args) {
		if(args[0].equals("gcd")){
			long p = Long.parseLong(args[1]);
			long q = Long.parseLong(args[2]);
			System.out.println(Computation.gcdOf(p, q));
		}else if(args[0].equals("squares")){
			double[] values = Arrays.stream(args)
								.skip(1)
								.mapToDouble(Double::parseDouble)
								.toArray();
			System.out.println(Computation.sumOfSquares(values));
		}else if(args[0].equals("solve")){
			double a = Double.parseDouble(args[1]);
			double b = Double.parseDouble(args[2]);
			double c = Double.parseDouble(args[3]);
			var qe = new LegacyQE(a, b, c);
			double[] roots = qe.realRoots();
			System.out.printf("(%.2f, %.2f)%n", roots[0], roots[1]);
		}
	}
}


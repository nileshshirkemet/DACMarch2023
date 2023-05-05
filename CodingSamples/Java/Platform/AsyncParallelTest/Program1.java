import java.util.stream.*;

class Program {
	
	static class Computation {

		private long start;

		public long compute(int begin, int end) {
			start = System.currentTimeMillis();
			return IntStream.range(begin, end)
						.mapToLong(Worker::doWork)
						.sum();
		}

		public double time() {
			long stop = System.currentTimeMillis();
			return (stop - start) / 1000.0;
		}

	}

	public static void main(String[] args) throws Exception {
		int n = Integer.parseInt(args[0]);
		System.out.print("Computing...");
		var c = new Computation();
		long r = c.compute(1, n + 1);
		System.out.println("Done!");
		System.out.printf("Result = %d, computed in %.3f seconds.%n", r, c.time());
	}
}


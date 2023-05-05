import java.util.stream.*;
import java.util.concurrent.*;

class Program {
	
	static class Computation {

		private long start;

		public long compute(int begin, int end) {
			start = System.currentTimeMillis();
			return IntStream.range(begin, end)
						.mapToLong(Worker::doWork)
						.sum();
		}

		public CompletableFuture<Long> computeAsync(int begin, int end) {
			//the supplied expression is evaluated by a pooled thread 
			//allowing the caller thread to resume its own execution
			//and to accept the result of evaluation at a time in
			//future when the evaluation is completed
			return CompletableFuture.supplyAsync(() -> compute(begin, end));
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
		var job = c.computeAsync(1, n + 1)
					.thenAccept(r -> {
						System.out.println("Done!");
						System.out.printf("Result = %d, computed in %.3f seconds.%n", r, c.time());
					});
		while(!job.isDone()){
			System.out.print(".");
			Thread.sleep(500);
		}
	}
}


class Program {

	private static String client;

	private static void handleJob(int id) {
		System.out.printf("Thread<%x> accepted job<%d> for %s%n", Thread.currentThread().hashCode(), id, client);
		Worker.doWork(id);
		System.out.printf("Thread<%x> finished job<%d> for %s%n", Thread.currentThread().hashCode(), id, client);
	}

	public static void main(String[] args) throws Exception {
		int n = args.length > 0 ? Integer.parseInt(args[0]) : 1;
		Thread child = new Thread(() -> {
			client = "Jack";
			handleJob(n);
		});
		child.start();
		client = "Jill";
		handleJob(2);
	}
}


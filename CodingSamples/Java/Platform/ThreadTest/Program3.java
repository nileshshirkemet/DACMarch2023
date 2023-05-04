class Program {

	private static ThreadLocal<String> client = new ThreadLocal<>();

	private static void handleJob(int id) {
		System.out.printf("Thread<%x> accepted job<%d> for %s%n", Thread.currentThread().hashCode(), id, client.get());
		Worker.doWork(id);
		System.out.printf("Thread<%x> finished job<%d> for %s%n", Thread.currentThread().hashCode(), id, client.get());
	}

	public static void main(String[] args) throws Exception {
		int n = args.length > 0 ? Integer.parseInt(args[0]) : 1;
		Thread child = new Thread(() -> {
			client.set("Jack");
			handleJob(n);
		});
		child.setDaemon(n > 10);
		child.start();
		client.set("Jill");
		handleJob(2);
	}
}


class Worker {

	public static void doWork(int amount) {
		long future = System.currentTimeMillis() + 1000 * amount;
		while(System.currentTimeMillis() < future);
	}
}



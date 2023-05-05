class Worker {

	public static long doWork(int amount) {
		long future = System.currentTimeMillis() + amount * 100;
		while(System.currentTimeMillis() < future);
		return amount * amount;
	}
}



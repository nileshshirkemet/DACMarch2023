class Program {

	static class JointAccount {

		private int balance;

		public int balance() {
			return balance;
		}

		public synchronized void deposit(int amount) {
			balance = Worker.doWork(amount, balance, 1);
			notify(); //signal this object
		}

		public boolean withdraw(int amount) {
			boolean success = false;
			//each object has its own monitor which can be locked by only
			//one thread at a time to execute a code block synchronized
			//on that object while other threads must wait until this 
			//thread unlocks it by exiting the synchronized block
			synchronized(this){
				if(balance >= amount){
					balance = Worker.doWork(amount, balance, -1);
					success = true;
				}
			}
			return success;
		}

		public synchronized boolean withdrawAfterDeposit(int amount) throws InterruptedException {
			//temporarily unlock the monitor of this object and wait
			//to relock it once some other thread signals this object
			wait();
			return withdraw(amount);
		}
	}

	public static void main(String[] args) throws Exception {
		var acc = new JointAccount();
		acc.deposit(7000);
		System.out.println("Opened joint-account for Jack and Jill.");
		System.out.printf("Initial balance = %d%n", acc.balance());
		Thread child = new Thread(() -> {
			System.out.println("Jack is withdrawing 4000...");
			if(acc.withdraw(4000) == false)
				System.out.println("Jack's withdraw operation failed!");
		});
		child.start();
		System.out.println("Jill is withdrawing 5000...");
		if(acc.withdraw(5000) == false)
			System.out.println("Jill's withdraw operation failed!");
		child.join(); //wait for child thread to exit
		System.out.printf("Final balance = %d%n", acc.balance());
	}
}



class Program {

	static class JointAccount {

		private int balance;

		public int balance() {
			return balance;
		}

		public void deposit(int amount) {
			balance = Worker.doWork(amount, balance, 1);
		}

		public boolean withdraw(int amount) {
			boolean success = false;
			if(balance >= amount){
				balance = Worker.doWork(amount, balance, -1);
				success = true;
			}
			return success;
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



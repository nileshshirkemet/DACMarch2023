package banking;

final class SavingsAccount extends Account implements Profitable {

	//a field declared with final modifier cannot be reassigned
	//after it is initialized also a single value of a field
	//declared with static modifier is shared by all the instances
	//of its class
	final static double MIN_BAL = 5000;

	SavingsAccount() {
		balance = MIN_BAL;
	}

	public void withdraw(double amount) throws InsufficientFundsException {
		if(balance - amount < MIN_BAL)
			throw new InsufficientFundsException();
		balance -= amount;
	}

	public void deposit(double amount) {
		balance += amount;
	}

	public double interest(int months) {
		float rate = balance < 20000 ? MIN_RATE : MIN_RATE + 1;
		return balance * months * rate / 1200;
	}
}


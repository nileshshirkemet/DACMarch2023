package banking;

final class SavingsAccount extends Account {

	//a field declared with final modifier cannot be reassigned
	//after it is initialized
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
}


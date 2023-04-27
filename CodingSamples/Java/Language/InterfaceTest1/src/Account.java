package banking;

//a class defined with abstract modifier cannot be instantiated
public abstract class Account {

	long id;
	protected double balance;

	public long getId() {
		return id;
	}

	public double getBalance() {
		return balance;
	}

	//an instance method declared with abstract modifier
	//is a pure method and it must be overridden by the subclass
	public abstract void deposit(double amount);

	public abstract void withdraw(double amount) throws InsufficientFundsException;

	//a method declared with final modifier cannot be overridden in a subclass,
	//for such a method (slow) dynamic binding is not required at runtime
	public final void transfer(double amount, Account that) throws InsufficientFundsException {
		if(this == that)
			throw new IllegalTransferException();
		this.withdraw(amount);
		that.deposit(amount);
	}
}


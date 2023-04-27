package banking;

public class Banker {

	private static long seed;

	//static code block is executed once when the class
	//is used for the first time by the executing program
	//allowing this class to initialize its static fields 
	static {
		seed = System.currentTimeMillis() % 100000000L;
	}

	public static Account openCurrentAccount() {
		var acc = new CurrentAccount(); //var = CurrentAccount
		acc.id = ++seed + 1000000000L;
		return acc;
	}

	public static Account openSavingsAccount() {
		var acc = new SavingsAccount();
		acc.id = ++seed + 2000000000L;
		return acc;
	}

	//private constructor to stop instantiation of this class
	//since all of its members are static
	private Banker() {}
}


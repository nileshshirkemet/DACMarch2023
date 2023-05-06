import banking.*;

class Program {

	private static void payAnnualInterest(Account[] accounts) {
		for(Account acc : accounts) {
			if(acc instanceof SavingsAccount s){
				double amount = s.interest(12);
				acc.deposit(amount);
			}
		}
	}

	public static void main(String[] args) {
		Account[] bank = new Account[5];
		bank[0] = new SavingsAccount();
		bank[0].deposit(5000);
		bank[1] = new CurrentAccount();
		bank[1].deposit(20000);
		bank[2] = new SavingsAccount();
		bank[2].deposit(25000);
		bank[3] = new CurrentAccount();
		bank[3].deposit(40000);
		bank[4] = new SavingsAccount();
		bank[4].deposit(45000);
		payAnnualInterest(bank);
		for(Account acc : bank)
			System.out.printf("%d\t%.2f%n", acc.getId(), acc.getBalance());
	}
}


import taxation.*;

class Program {

	//inner nested member class - a class defined inside another class
	//with static modifier so that it can only refer to static members
	//of its outer class
	static class Auditor {

		public Auditor() {
			System.out.println("Auditing begins...");
		}

		public void audit(String id, TaxPayer emp) {
			if(id.length() < 4)
				throw new IllegalArgumentException("Invalid ID");
			double payment = emp.incomeTax() + 250;
			System.out.printf("Total Tax Payment: %.2f%n", payment);
		}

		public void close() {
			System.out.println("Auditing ends.");
		}

	}

	private static void action(String name, int count) {
		TaxPayer t = name.equals("jack") ? new Supervisor(count) : new Worker(count);
		Auditor a = new Auditor();
		try{
			a.audit(name, t);
		}finally{
			a.close();
		}
	}

	public static void main(String[] args) {
		try{
			String name = args[0].toLowerCase();
			int count = Integer.parseInt(args[1]);
			action(name, count);
		}catch(Exception e){
			System.out.printf("Action failed: %s%n", e.getMessage());
		}
	}
}


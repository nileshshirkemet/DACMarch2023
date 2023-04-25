//importing unqualified name Employee into current (default) package
//so that compiler can translate it to payroll.Employee
import payroll.Employee;
import payroll.SalesPerson;

class Program {

	private static double tax(Employee emp) {
		double i = emp.income();
		return i > 10000 ? 0.15 * (i - 10000) : 0; 
	}

	public static double bonus(Employee emp) {
		if(emp instanceof SalesPerson)
			return 0;
		return 0.1 * emp.income();
	}

	public static void main(String[] args) {
		Employee jack = new Employee();
		jack.setHours(186);
		jack.setRate(52);
		System.out.printf("Jack's income is %.2f, tax is %.2f and bonus is %.2f%n", jack.income(), tax(jack), bonus(jack));
		SalesPerson jill = new SalesPerson(186, 52, 68000);
		System.out.printf("Jill's income is %.2f, tax is %.2f and bonus is %.2f%n", jill.income(), tax(jill), bonus(jill));
		
	}
}



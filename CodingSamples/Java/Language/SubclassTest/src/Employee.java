package payroll;

//class declared with public modifier is visible outside of its package
public class Employee {

	private int hours;
	private float rate;

	//parameterized constructor
	public Employee(int h, float r) {
		hours = h;
		rate = r;
	}

	//parameterless constructor
	public Employee() {
		this(0, 40); //calling above constructor
	}

	//accessor methods
	public int getHours() {
		return hours;
	}

	public void setHours(int value) {
		hours = value;
	}

	public float getRate() {
		return rate;
	}

	public void setRate(float value) {
		rate = value;
	}

	//overridable instance method
	public double income() {
		double amount = hours * rate;
		int ot = hours - 180;
		if(ot > 0)
			amount += 50 * ot;
		return amount;
	}
}


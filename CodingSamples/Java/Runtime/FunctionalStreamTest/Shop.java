import java.util.*;

/*
	A record type produces immutable objects (with read-only state). A record
	declaration is translated by the compiler into a final class with 
	following auto-generated features
	1. private final fields corresponding to the positional parameters
	   specified in the declaration
	2. a paramaterized constructor to initialize above fields and
	   methods which return their values
	3. overrides for toString(), hashCode() and equals() methods
	   based on above fields
*/
record Item(String name, String brand) {}

record Customer(String id, double purchase, int rating) implements Comparable<Customer> {

	public int compareTo(Customer other) {
		return id.compareTo(other.id);
	}
}

class Shop {

	public static Item[] getItems() {
		return new Item[] {
			new Item("cpu", "intel"),
			new Item("ssd", "samsung"),
			new Item("motherboard", "intel"),
			new Item("ddr", "samsung"),
			new Item("cpu", "amd"),
			new Item("ssd", "seagate"),
			new Item("keyboard", "logitech"),
			new Item("mouse", "microsoft"),
			new Item("monitor", "samsung"),
			new Item("mouse", "logitech"),
			new Item("ddr", "seagate")
		};
	}

	public static Collection<Customer> getCustomers() {
		Collection<Customer> customers = new ArrayList<>();
		customers.add(new Customer("mayur", 42000, 3));
		customers.add(new Customer("ganesh", 58000, 5));
		customers.add(new Customer("pritesh", 19000, 2));
		customers.add(new Customer("sayali", 68000, 4));
		customers.add(new Customer("vishal", 12500, 5));
		customers.add(new Customer("nikita", 43000, 3));
		customers.add(new Customer("komal", 25000, 1));
		customers.add(new Customer("rohit", 78000, 5));
		customers.add(new Customer("aditi", 36000, 4));
		return customers;
	}
}


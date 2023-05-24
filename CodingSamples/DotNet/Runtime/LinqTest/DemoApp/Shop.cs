using System.Collections.Generic;

/*
    A reference (default) type record produces immutable
    objects and its declaration is translated by the compiler 
    into the corresponding class with following auto-generated 
    members
    (1) a read-only property for each positional parameter 
        specified in the declaration
    (2) a parameterized constructor for initializing values
        of above properties
    (3) overrides for ToString(), GetHashCode() and Equals()
        methods of System.Object 
*/
record Item(string Name, string Brand);

record Customer(string Id, decimal Purchase, int Rating);

class Shop
{
    public static Item[] GetItems()
    {
		return new Item[] 
        {
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

    public static ICollection<Customer> GetCustomers()
    {
        ICollection<Customer> customers = new List<Customer>();
		customers.Add(new Customer("mayur", 42000, 3));
		customers.Add(new Customer("ganesh", 58000, 5));
		customers.Add(new Customer("pritesh", 19000, 2));
		customers.Add(new Customer("sayali", 68000, 4));
		customers.Add(new Customer("vishal", 12500, 5));
		customers.Add(new Customer("nikita", 43000, 3));
		customers.Add(new Customer("komal", 25000, 1));
		customers.Add(new Customer("rohit", 78000, 5));
		customers.Add(new Customer("aditi", 36000, 4));
        return customers;
    }
}

record Item(string Name, string Brand);

record Customer(string Id, decimal Purchase, int Rating, string City = "Mumbai");

class Shop
{
	public readonly static Item BestItem = new Item("ssd", "samsung");

	public readonly static Customer BestCustomer = new Customer("ganesh", 58000, 5);

}
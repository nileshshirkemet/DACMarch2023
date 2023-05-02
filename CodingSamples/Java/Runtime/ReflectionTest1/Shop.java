record Item(String name, String brand) {}

record Customer(String id, double purchase, int rating) {}

class Shop {

	public static Item getCommonItem() {
		return new Item("ssd", "samsung");
	}

	public static Customer getBestCustomer() {
		return new Customer("ganesh", 58000, 5);
	}
}


class Program {

	private static void present(Item info) {
		System.out.println("<Item>");
		System.out.printf("  <name>%s</name>%n", info.name());
		System.out.printf("  <brand>%s</brand>%n", info.brand());
		System.out.println("</Item>");
	}

	private static void present(Customer info) {
		System.out.println("<Customer>");
		System.out.printf("  <id>%s</id>%n", info.id());
		System.out.printf("  <purchase>%s</purchase>%n", info.purchase());
		System.out.printf("  <rating>%s</rating>%n", info.rating());
		System.out.println("</Customer>");
	}

	public static void main(String[] args) {
		present(Shop.getCommonItem());
		System.out.println();
		present(Shop.getBestCustomer());
	}
}


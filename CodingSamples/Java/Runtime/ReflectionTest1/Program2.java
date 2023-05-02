class Program {

	private static void present(Object info) {
		Class<?> c = info.getClass();
		System.out.printf("<%s>%n", c.getName());
		for(var rc : c.getRecordComponents()) {
			System.out.printf("  <%s>", rc.getName());
			try{
				System.out.print(rc.getAccessor().invoke(info));
			}catch(Exception e){}
			System.out.printf("</%s>%n", rc.getName());
		}
		System.out.printf("</%s>%n", c.getName());
	}

	public static void main(String[] args) {
		present(Shop.getCommonItem());
		System.out.println();
		present(Shop.getBestCustomer());
	}
}


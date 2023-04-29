class Program {

	public static void main(String[] args) {
		SimpleStack<String> a = new SimpleStack<String>();
		a.push("Monday");
		a.push("Tuesday");
		a.push("Wednesday");
		a.push("Thursday");
		a.push("Friday");
		for(var i = a.iterator(); i.hasNext();)
			System.out.println(i.next());
		System.out.println("---------------------");
		while(!a.empty())
			System.out.println(a.pop());
		System.out.println("---------------------");
		SimpleStack<Double> b = new SimpleStack<Double>();
		b.push(43.1);
		b.push(65.2);
		b.push(54.3);
		b.push(39.4);
		for(double d : b)
			System.out.println(d);
	}
}


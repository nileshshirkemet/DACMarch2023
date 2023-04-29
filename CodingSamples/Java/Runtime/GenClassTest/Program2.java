class Program {

	//private static void printStack(SimpleStack<? extends Object> stack) {
	private static void printStack(SimpleStack<?> stack) {
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
		//stack.push(23.4);
	}

	public static void main(String[] args) {
		SimpleStack<String> a = new SimpleStack<String>();
		a.push("Monday");
		a.push("Tuesday");
		a.push("Wednesday");
		a.push("Thursday");
		a.push("Friday");
		printStack(a);
		System.out.println("----------------------");
		SimpleStack<Interval> b = new SimpleStack<>(); 
		b.push(new Interval(4, 31));
		b.push(new Interval(6, 12));
		b.push(new Interval(5, 43));
		b.push(new Interval(3, 24));
		printStack(b);
	}
}


import java.util.*;

class Program {

	static class IntervalComparison implements Comparator<Interval> {
		public int compare(Interval x, Interval y) {
			return x.seconds() - y.seconds();
		}
	}

	public static void main(String[] args) {
		if(args.length == 0){
			//Collection<Interval> store = new ArrayList<>();
			//Collection<Interval> store = new LinkedList<>();
			//Collection<Interval> store = new HashSet<>();
			//Collection<Interval> store = new TreeSet<>();
			Collection<Interval> store = new TreeSet<>(new IntervalComparison());
			store.add(new Interval(4, 31));
			store.add(new Interval(6, 12));
			store.add(new Interval(7, 23));
			store.add(new Interval(5, 54));
			store.add(new Interval(3, 45));
			store.add(new Interval(2, 151));
			for(Interval i : store)
				System.out.println(i);
		}else{
			//Map<String, Interval> store = new HashMap<>();
			Map<String, Interval> store = new TreeMap<>();
			store.put("monday", new Interval(4, 31));
			store.put("tuesday", new Interval(6, 12));
			store.put("wednesday", new Interval(7, 23));
			store.put("thursday", new Interval(5, 54));
			store.put("friday", new Interval(3, 45));
			store.put("monday", new Interval(8, 31));
			Interval val = store.get(args[0]);
			if(val != null){
				System.out.printf("Value = %s%n", val);
			}else{
				for(var pair : store.entrySet())
					System.out.printf("%-12s%8s%n", pair.getKey(), pair.getValue());
			}
		}
	}
}


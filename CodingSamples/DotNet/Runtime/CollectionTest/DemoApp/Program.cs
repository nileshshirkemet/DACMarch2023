
class Program
{
    class IntervalComparison : IComparer<Interval>
    {
        public int Compare(Interval x, Interval y)
        {
            return x.Seconds - y.Seconds;
        }
    }

    static void Main(string[] args)
    {
        if(args.Length == 0)
        {
            //ICollection<Interval> store = new List<Interval>();
            //ICollection<Interval> store = new HashSet<Interval>();
            //ICollection<Interval> store = new SortedSet<Interval>();
            ICollection<Interval> store = new SortedSet<Interval>(new IntervalComparison());
            store.Add(new Interval(4, 31));
            store.Add(new Interval(6, 12));
            store.Add(new Interval(7, 23));
            store.Add(new Interval(5, 54));
            store.Add(new Interval(3, 45));
            store.Add(new Interval(2, 151));
            foreach(Interval i in store)
                Console.WriteLine(i);
        }
        else
        {
            //IDictionary<string, Interval> store = new Dictionary<string, Interval>();
            //IDictionary<string, Interval> store = new SortedDictionary<string, Interval>();
            IDictionary<string, Interval> store = new SortedList<string, Interval>();
            store.Add("monday", new Interval(4, 31));
            store.Add("tuesday", new Interval(6, 12));
            store.Add("wednesday", new Interval(7, 23));
            store["thursday"] = new Interval(5, 54);
            store["friday"] = new Interval(3, 45);
            store["monday"] = new Interval(8, 31);
            if(store.TryGetValue(args[0], out Interval val))
            {
                Console.WriteLine(val);
            }
            else
            {
                foreach(var pair in store)
                    Console.WriteLine("{0, -16}{1, 8}", pair.Key, pair.Value);
            }
        }
    }
}

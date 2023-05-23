
class Program
{
    static V Sum<V>(SimpleStack<V> store) where V: IAdditionOperators<V, V, V>, new()
    {
        V total = new V();
        foreach(V item in store)
            total += item;
        return total;
    }

    static void Main(string[] args)
    {
        SimpleStack<double> a = new SimpleStack<double>();
        a.Push(34.1);
        a.Push(47.2);
        a.Push(58.3);
        a.Push(62.4);
        a.Push(23.5);
        a.Push(19.6);
        a[3] = 51.3; //using indexer
        for(var e = a.GetEnumerator(); e.MoveNext();)
            Console.WriteLine(e.Current);
        Console.WriteLine("Total = {0}", Sum(a));
        Console.WriteLine("------------------");
        SimpleStack<Interval> b = new SimpleStack<Interval>();
        b.Push(new Interval(4, 31));
        b.Push(new Interval(6, 52));
        b.Push(new Interval(7, 23));
        b.Push(new Interval(5, 14));
        b.Push(new Interval(3, 45));
        foreach(Interval i in b)
            Console.WriteLine(i);
        Console.WriteLine("Total = {0}", Sum(b));
    }
}

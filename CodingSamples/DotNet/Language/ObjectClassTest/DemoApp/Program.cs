class Program
{
    static void Present(object info, string label)
    {
        Console.WriteLine("{0} = {1}", label, info.ToString());
    }

    static void Main(string[] args)
    {
        Interval a = new Interval(4, 5);
        Interval b = new Interval(2, 30);
        Interval c = new Interval(3, 65);
        Interval d = b;
        Present(a, "Interval a");
        Present(b, "Interval b");
        Present(c, "Interval c");
        Present(d, "Interval d");
        Present(a + b + c + d, "Total Interval");
        Console.WriteLine("------------------------");
        Console.WriteLine("a is identical to b: {0}", ReferenceEquals(a, b));
        Console.WriteLine("a is identical to c: {0}", ReferenceEquals(a, c));
        Console.WriteLine("d is identical to b: {0}", ReferenceEquals(d, b));
        Console.WriteLine("------------------------");
        Console.WriteLine("a is equal to b: {0}", a.GetHashCode() == b.GetHashCode() && a.Equals(b));        
        Console.WriteLine("a is equal to c: {0}", a.GetHashCode() == c.GetHashCode() && a.Equals(c));        
        Console.WriteLine("d is equal to b: {0}", d.GetHashCode() == b.GetHashCode() && d.Equals(b));        
        Banner e = new Banner(18.5f, 12.5f);
        //auto-boxing for conversion of a value-type (Banner) instance
        //to a reference type (System.Object) identity
        Present(e, "My Banner");
    }
}
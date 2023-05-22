class Program
{
    static void Main(string[] args)
    {
        SimpleStack<string> a = new SimpleStack<string>();
        a.Push("Monday");
        a.Push("Tuesday");
        a.Push("Wednesday");
        a.Push("Thursday");
        a.Push("Friday");
        //a.Push(9.8);
        while(!a.Empty())
            Console.WriteLine(a.Pop());
        Console.WriteLine("-------------------");
        SimpleStack<Interval> b = new SimpleStack<Interval>();
        b.Push(new Interval(5, 21));
        b.Push(new Interval(7, 42));
        b.Push(new Interval(6, 13));
        b.Push(new Interval(4, 54));
        while(!b.Empty())
            Console.WriteLine(b.Pop());
    }
}

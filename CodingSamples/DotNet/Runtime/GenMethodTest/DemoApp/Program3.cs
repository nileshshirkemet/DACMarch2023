class Program
{
    //generic method with type-parameter T
    static T Select<T>(int index, T first, T second) 
    {
        if((index % 2) == 1)
            return first;
        return second;
    }

    static T Select<T>(T first, T second) where T: IComparable<T>
    {
        if(first.CompareTo(second) > 0)
            return first;
        return second;
    }

    static void Main(string[] args)
    {
        if(args.Length > 0)
        {
            int s = int.Parse(args[0]);
            string ss = Select(s, "Monday", "Friday");
            Console.WriteLine($"Selected string = {ss}");
            double sd = Select(s, 54.3, 67.8);
            Console.WriteLine($"Selected string = {sd}");
            //sd = Select(s, "abcd", 123.4);
        }
        else
        {
            string ss = Select("Monday", "Friday");
            Console.WriteLine($"Selected string = {ss}");
            double sd = Select(54.3, 67.8);
            Console.WriteLine($"Selected string = {sd}");  
            Interval si = Select(new Interval(3, 45), new Interval(2, 30));
            Console.WriteLine($"Selected Interval = {si}");  
        }
    }
}

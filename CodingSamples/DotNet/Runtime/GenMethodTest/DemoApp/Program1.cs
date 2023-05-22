class Program
{
    static string Select(int index, string first, string second)
    {
        if((index % 2) == 1)
            return first;
        return second;
    }

    static double Select(int index, double first, double second)
    {
        if((index % 2) == 1)
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
    }
}

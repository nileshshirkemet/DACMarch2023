class Program
{
    static object Select(int index, object first, object second)
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
            string ss = (string) Select(s, "Monday", "Friday");
            Console.WriteLine($"Selected string = {ss}");
            double sd = (double) Select(s, 54.3, 67.8);
            Console.WriteLine($"Selected string = {sd}");
            sd = (double)Select(s, "abcd", 123.4);
        }
    }
}

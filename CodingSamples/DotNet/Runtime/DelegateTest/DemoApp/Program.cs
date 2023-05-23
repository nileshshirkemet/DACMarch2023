class Program
{
    static float SafeScheme(int n)
    {
        return n <= 3 ? 6 : 7;
    }

    static void Main(string[] args)
    {
        double p = double.Parse(args[0]);
        int n = int.Parse(args[1]);
        Investment my = new Investment(p, n);
        Console.WriteLine("Future value of safe investment: {0:0.00}", my.FutureValue(SafeScheme));
        //passing lambda-expression (anonymous method) for delegate
        Console.WriteLine("Future value of risky investment: {0:0.00}", my.FutureValue(y => 10 + 0.5f * y));
    }
}

/*
    C# supports top-level statements which are
    inserted by the compiler into the Main method
    of the auto-generated Program class
*/ 

Console.WriteLine("Average of two values = {0:0.000}", Statistics.Average(46.2, 51.3));
Console.WriteLine("Average of two values = {0:0.000}", Statistics.Average(46.2, 51.3, 32.4));
Console.WriteLine("Average of two values = {0:0.000}", Statistics.Average(46.2, 51.3, 32.4, 68.1, 26.7));
if(args.Length > 1)
{
    double x = double.Parse(args[0]);
    double y = double.Parse(args[1]);
    double a = Statistics.AverageWithDeviation(x, y, out double d);
    Console.WriteLine("Average of given values is {0:0.000} with a deviation of {1:0.00}", a, d);
}
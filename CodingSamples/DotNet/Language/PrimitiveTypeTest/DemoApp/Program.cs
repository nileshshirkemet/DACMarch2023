using System;

class Program
{
	static void Main(string[] args)
	{
		double p = double.Parse(args[0]);
		int n = int.Parse(args[1]);
		Console.WriteLine("Future value of no risk investment:  {0:0.00}", Investment.FutureValue(p, n));
		Console.WriteLine("Future value of low risk investment: {0:0.00}", Investment.FutureValue(p, n, true));
	}
}

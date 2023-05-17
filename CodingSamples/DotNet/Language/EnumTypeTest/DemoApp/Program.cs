global using System;

class Program
{
	static void Advise(ref Investment inv)
	{
		inv.AllowRisk(inv.TotalAmount() < 500000);
	}
	static void Main(string[] args)
	{
		double p = double.Parse(args[0]);
		int n = int.Parse(args[1]);
		Investment my = new Investment(p, n);
		Console.WriteLine("Future value of no risk investment:  {0:0.00}", my.FutureValue());
		my.AllowRisk(true);
		Console.WriteLine("Future value of low risk investment: {0:0.00}", my.FutureValue());
		Advise(ref my); 
		Console.WriteLine("Future value of smart investment: {0:0.00}", my.FutureValue());
		my.AllowRisk(RiskLevel.High);
		Console.WriteLine("Future value of high risk investment: {0:0.00}", my.FutureValue());
	}
}

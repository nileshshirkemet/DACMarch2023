global using System;

class Program
{
	//parameter qualified with 'ref' key-word expects
	//reference (address indicator) to the value of 
	//argument passed (insteadof its copy)
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
		Advise(ref my); //passing a reference
		Console.WriteLine("Future value of smart investment: {0:0.00}", my.FutureValue());
	}	
}

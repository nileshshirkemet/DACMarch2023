using System.Reflection;

delegate double InterestScheme(double amount, int period);

class Program
{
    public static void Main(string[] args)
    {
        double p = double.Parse(args[0]);
        Type t = Type.GetType($"Finance.{args[1]}Loan,BankLib");
        //MethodInfo mi = t.GetMethod(args[2], new Type[]{typeof(double), typeof(int)});
        MethodInfo mi = t.GetMethod(args[2]);
        object policy = Activator.CreateInstance(t);
        InterestScheme scheme = mi.CreateDelegate<InterestScheme>(policy);
        int m = 10;
        for(int n = 1; n <= m; ++n)
        {
            double rate = scheme(p, n); 
            double i = rate / 1200;
            double emi = p * i / (1 - Math.Pow(1 + i, -12 * n));
            Console.WriteLine("{0, -6}{1, 12:0.00}", n, emi);
        }
    }
}

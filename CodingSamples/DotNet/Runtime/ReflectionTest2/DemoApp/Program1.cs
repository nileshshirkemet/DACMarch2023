double p = double.Parse(args[0]);
Type t = Type.GetType($"Finance.{args[1]},BankLib");
//dynamic type declaration is not checked at compile time
//instead runtime binder is used for resolving its members
dynamic policy = Activator.CreateInstance(t);
int m = 10;
for(int n = 1; n <= m; ++n)
{
    double rate = policy.Common(p, n); //duck typing
    double i = rate / 1200;
    double emi = p * i / (1 - Math.Pow(1 + i, -12 * n));
    Console.WriteLine("{0, -6}{1, 12:0.00}", n, emi);
}
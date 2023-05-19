using Banking;

Account jack = Banker.OpenCurrentAccount();
jack.Deposit(20000);
Account jill = Banker.OpenSavingsAccount();
jill.Deposit(15000);
try
{
    double payment = double.Parse(args[0]);
    jill.Transfer(payment, jack);
    Console.WriteLine("Payment succeeded.");
}
catch(InsufficientFundsException)
{
    jill.LockAccount(); //Banker.LockAccount(jill);
    Console.WriteLine("Payment failed due to lack of funds!");
}
catch(Exception ex)
{
    Console.WriteLine("Error: {0}", ex.Message);
}
Console.WriteLine("Jack's Account ID is {0} and Balance is {1:0.00}", jack.Id, jack.Balance);
Console.WriteLine("Jill's Account ID is {0} and Balance is {1:0.00}", jill.Id, jill.Balance);

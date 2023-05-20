namespace Banking;

class SavingsAccount : Account, IProfitable
{
    const double MinBal = 5000;

    internal SavingsAccount()
    {
        Balance = MinBal;
    }

    public override void Deposit(double amount)
    {
        Balance += amount;
    }

    public override void Withdraw(double amount)
    {
        if(Balance - amount < MinBal)
            throw new InsufficientFundsException();
        Balance -= amount;
    }

    public void AddInterest(int months)
    {
        float rate = Balance < 3 * MinBal ? 4.0f : 4.5f;
        Balance += Balance * rate * months / 1200;
    }
}

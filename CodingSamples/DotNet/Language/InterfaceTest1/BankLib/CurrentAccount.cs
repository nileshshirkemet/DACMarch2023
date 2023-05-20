namespace Banking;

//a class declared with sealed modifier cannot
//be used as a base class
sealed class CurrentAccount : Account, IFineable
{
    public override void Deposit(double amount)
    {
        Balance += amount;        
    }

    public override void Withdraw(double amount)
    {
        Balance -= amount;
    }

    //explicit implementation of IFineable
    bool IFineable.Withdraw(double fine)
    {
        if(Balance < 0)
        {
            Balance -= fine;
            return true;
        }
        return false;
    }
}

namespace Banking;

//a class declared with abstract modifier
//does not support activation
public abstract class Account
{
    public long Id { get; internal set; }

    public double Balance { get; protected set; }

    //a method declared with abstract modifier must
    //be overridden in a non-abstract derived class
    public abstract void Deposit(double amount);

    public abstract void Withdraw(double amount);

    public void Transfer(double amount, Account that)
    {
        if(!ReferenceEquals(this, that))
        {
            this.Withdraw(amount);
            that.Deposit(amount);
        }
    }
}
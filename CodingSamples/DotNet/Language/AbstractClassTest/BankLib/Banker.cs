namespace Banking;

//a class declared with static modifier only contains
//static members and such does not support a constructor
public static class Banker
{
    private static long seed;

    //a static constructor is invoked once when
    //the type is referenced for the first time
    //within the executing application
    static Banker()
    {
        seed = DateTime.Now.Ticks % 1000000;
    }

    public static Account OpenCurrentAccount()
    {
        var acc = new CurrentAccount(); //var = CurrentAccount
        acc.Id = ++seed + 100000000L;
        return acc;
    }

    public static Account OpenSavingsAccount()
    {
        SavingsAccount acc = new();
        acc.Id = ++seed + 200000000L;
        return acc;
    }

    //An extension method is a member of a static class 
    //whose first parameter is declared with 'this' keyword.
    //Such a method can be called as an instance method
    //of its first parameter type by using namespace of its class
    public static void LockAccount(this Account target)
    {
        target.Id = -target.Id;
    }
}
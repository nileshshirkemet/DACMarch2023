class Program
{
    class JointAccount
    {
        public int Balance { get; private set; }

        public void Deposit(int amount)
        {
            Balance = Worker.DoWork(amount, Balance, 1);
        }

        public bool Withdraw(int amount)
        {
            bool success = false;
            if(Balance >= amount)
            {
                Balance = Worker.DoWork(amount, Balance, -1);
                success = true;
            }
            return success;
        }
    }

    static void Main(string[] args)
    {
        var acc = new JointAccount();
        acc.Deposit(7000);
        Console.WriteLine("Joint account opened for Jack and Jill.");
        Console.WriteLine("Initial Balance = {0}", acc.Balance);
        Console.WriteLine("Jack is withdrawing 4000...");
        if(acc.Withdraw(4000) == false)
            Console.WriteLine("Jack's withdraw operation failed!");
        Console.WriteLine("Jill is withdrawing 5000...");
        if(acc.Withdraw(5000) == false)
            Console.WriteLine("Jill's withdraw operation failed!");
        Console.WriteLine("Final Balance = {0}", acc.Balance);
    }
}

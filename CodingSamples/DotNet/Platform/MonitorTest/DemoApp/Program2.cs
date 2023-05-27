class Program
{
    class JointAccount
    {
        public int Balance { get; private set; }

        public bool Withdraw(int amount)
        {
            bool success = false;
            //Lock the monitor of 'this' object and resume execution.
            //Only one thread can lock the monitor of a given object
            //at a time while other threads must wait for this monitor
            //to be unlocked by its locking thread.
            Monitor.Enter(this);
            if(Balance >= amount)
            {
                Balance = Worker.DoWork(amount, Balance, -1);
                success = true;
            }
            Monitor.Exit(this); //unlock monitor of this object
            return success;
        }

        public void Deposit(int amount)
        {
            lock(this)
            {
                Balance = Worker.DoWork(amount, Balance, 1);
                //signal monitor of this object
                Monitor.Pulse(this); 
            }
        }

        public bool WithdrawAfterDeposit(int amount)
        {
            lock(this)
            {
                //Temporarily unlock the monitor of this object
                //and wait for a signal to relock it 
                Monitor.Wait(this);
            }
            return Withdraw(amount);
        }

    }

    static void Main(string[] args)
    {
        var acc = new JointAccount();
        acc.Deposit(7000);
        Console.WriteLine("Joint account opened for Jack and Jill.");
        Console.WriteLine("Initial Balance = {0}", acc.Balance);
        Thread child = new Thread(() => 
        {
            Console.WriteLine("Jack is withdrawing 4000...");
            if(acc.Withdraw(4000) == false)
                Console.WriteLine("Jack's withdraw operation failed!");            
        });
        child.Start();
        Console.WriteLine("Jill is withdrawing 5000...");
        if(acc.Withdraw(5000) == false)
            Console.WriteLine("Jill's withdraw operation failed!");
        child.Join(); //current (Main) thread waits for child thread to exit
        Console.WriteLine("Final Balance = {0}", acc.Balance);
    }
}

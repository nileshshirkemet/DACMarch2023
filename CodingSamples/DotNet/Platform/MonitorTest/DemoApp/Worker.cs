class Worker
{
    public static int DoWork(int amount, int balance, int op)
    {
        int t = Environment.TickCount + amount / 1000;
        while(Environment.TickCount < t);
        return balance + op * amount;
    }
}
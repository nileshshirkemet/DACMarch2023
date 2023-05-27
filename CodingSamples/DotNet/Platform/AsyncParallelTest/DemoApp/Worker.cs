class Worker
{
    public static long DoWork(int amount)
    {
        int t = Environment.TickCount + amount * 100;
        while(Environment.TickCount < t);
        return amount * amount;
    }
}
class Worker
{
    public static void DoWork(int amount)
    {
        int t = Environment.TickCount + amount * 1000;
        while(Environment.TickCount < t);
    }
}
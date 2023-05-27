class Computation
{
    private System.Diagnostics.Stopwatch clock = new();

    public long Compute(int begin, int end)
    {
        clock.Start();
        return Enumerable.Range(begin, end - begin)
                .Select(Worker.DoWork)
                .Sum();
    }

    public double Time()
    {
        clock.Stop();
        return clock.Elapsed.TotalSeconds;
    }
}

class Program
{

    static void DoComputation(int limit)
    {
        Console.Write("Computing...");
        var c = new Computation();
        long r = c.Compute(1, limit + 1);
        Console.WriteLine("Done.");
        Console.WriteLine("Result = {0}, computed in {1:0.000} seconds.", r, c.Time());
    }

    static void Main(string[] args)
    {
        int n = int.Parse(args[0]);
        DoComputation(n);
    }
}

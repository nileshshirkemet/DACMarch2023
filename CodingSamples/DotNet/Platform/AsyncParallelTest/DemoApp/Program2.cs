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

    public Task<long> ComputeAsync(int begin, int end)
    {
        //a method passed to Run is invoked by a pooled thread
        //allowing the caller thread to resume execution and 
        //obtain the result of this invocation when it is completed
        return Task<long>.Run(() => Compute(begin, end));
    }

    public double Time()
    {
        clock.Stop();
        return clock.Elapsed.TotalSeconds;
    }
}

class Program
{

    static Task DoComputation(int limit)
    {
        Console.Write("Computing...");
        var c = new Computation();
        return c.ComputeAsync(1, limit + 1)
                .ContinueWith(previous => 
                {
                    long r = previous.Result;
                    Console.WriteLine("Done.");
                    Console.WriteLine("Result = {0}, computed in {1:0.000} seconds.", r, c.Time());                    
                });

    }

    static void Main(string[] args)
    {
        int n = int.Parse(args[0]);
        Task job = DoComputation(n);
        while(!job.IsCompleted)
        {
            Console.Write(".");
            Thread.Sleep(500);
        }
    }
}

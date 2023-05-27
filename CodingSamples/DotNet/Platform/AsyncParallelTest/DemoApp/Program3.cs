class Computation
{
    private System.Diagnostics.Stopwatch clock = new();

    public long Compute(int begin, int end)
    {
        clock.Start();
        return Enumerable.Range(begin, end - begin)
                .AsParallel()
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

    //a method declared with 'async' keyword can return
    //a task using 'await' statement, which yields its
    //target task combined with another task that executes
    //its follow up statements
    static async Task DoComputation(int limit)
    {
        Console.Write("Computing...");
        var c = new Computation();
        long r = await c.ComputeAsync(1, limit + 1);
        Console.WriteLine("Done.");
        Console.WriteLine("Result = {0}, computed in {1:0.000} seconds.", r, c.Time());
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

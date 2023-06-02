namespace BasicWebApp.Services;

//state-full service: keeps data in instance field
public class CommonCounter : ICounter
{
    private int current = 0;

    public int CountNext(string key)
    {
        return Interlocked.Increment(ref current);
    }
}

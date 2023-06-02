namespace BasicWebApp.Services;

//state-less service 
public class NamedCounter : ICounter
{
    private static Dictionary<string, int> store = new();

    public int CountNext(string key)
    {
        lock(store)
        {
            store.TryGetValue(key, out int value);
            store[key] = ++value;
            return value;
        }
    }
}
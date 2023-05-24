using System.Collections.Generic;

static class Printable
{
    //a fluent function is a method whose return type supports
    //other such methods
    public static IEnumerable<string> Capitalize<V>(this IEnumerable<V> source)
    {
        foreach(V entry in source)
            yield return entry.ToString().ToUpper();
    }

    public static void PrintEach(this IEnumerable<string> source)
    {
        foreach(string entry in source)
            System.Console.WriteLine(entry);
    }
}
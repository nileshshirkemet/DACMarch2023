class Program
{
    static void Present(object info)
    {
        Type t = info.GetType();
        Console.WriteLine("<{0}>", t.Name);
        foreach(var prop in t.GetProperties())
            Console.WriteLine("  <{0}>{1}</{0}>", prop.Name, prop.GetValue(info));
        Console.WriteLine("</{0}>", t.Name);
    }
    
    static void Main(string[] args)
    {
        Present(Shop.BestItem);
        Console.WriteLine("---------------");
        Present(Shop.BestCustomer);
    }
}

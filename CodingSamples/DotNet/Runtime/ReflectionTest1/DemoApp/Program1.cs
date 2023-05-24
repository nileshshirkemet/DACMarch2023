class Program
{
    static void Present(Item info)
    {
        Console.WriteLine("<Item>");
        Console.WriteLine("  <Name>{0}</Name>", info.Name);
        Console.WriteLine("  <Brand>{0}</Brand>", info.Brand);
        Console.WriteLine("</Item>");
    }

    static void Present(Customer info)
    {
        Console.WriteLine("<Customer>");
        Console.WriteLine("  <Id>{0}</Id>", info.Id);
        Console.WriteLine("  <Purchase>{0}</Purchase>", info.Purchase);
        Console.WriteLine("  <Rating>{0}</Rating>", info.Rating);
        Console.WriteLine("</Customer>");
    }
    
    static void Main(string[] args)
    {
        Present(Shop.BestItem);
        Console.WriteLine("---------------");
        Present(Shop.BestCustomer);
    }
}

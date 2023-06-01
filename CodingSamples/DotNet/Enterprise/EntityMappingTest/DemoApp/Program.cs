using Shopping;

var db = new ShopDbContext();
if(args.Length == 0)
{
    foreach(var item in db.Products)
        Console.WriteLine("{0, -6}{1, 12:0.00}{2, 8}", item.Id, item.Price, item.Stock);
}
else
{
    int pno = int.Parse(args[0]);
    var product = db.Products
                    .Where(e => e.Id == pno)
                    .Include(e => e.Orders)
                    .FirstOrDefault();
    if(product != null)
    {
        foreach(var entry in product.Orders)
            Console.WriteLine("{0}\t{1}\t{2:yyyy-MM-dd}", entry.CustomerId, entry.Quantity, entry.OrderDate);
    }

}
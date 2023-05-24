using System.Linq;

if(args[0] == "items")
{
    Item[] items = Shop.GetItems();
    items.Where(i => i.Brand == args[1])
        .Select(i => i.Name)
        .Capitalize()
        .PrintEach();
}
else if(args[0] == "customers")
{
    decimal yield = decimal.Parse(args[1]);
    var customers = Shop.GetCustomers();
    var selection = from c in customers
                    where c.Purchase >= yield
                    orderby c.Id
                    select new
                    {
                        Name = c.Id,
                        Stars = new string('*', c.Rating)
                    };
    foreach(var entry in selection)
        System.Console.WriteLine("{0, -16}{1, 8}", entry.Name, entry.Stars);
}
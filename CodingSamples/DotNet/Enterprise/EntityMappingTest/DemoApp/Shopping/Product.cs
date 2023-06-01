namespace Shopping;

public class Product
{
    public int Id { get; set; }

    public decimal Price { get; set; }

    public int Stock { get; set; }

    //navigation property (one-to-many)
    public ICollection<Order> Orders { get; set; }
}
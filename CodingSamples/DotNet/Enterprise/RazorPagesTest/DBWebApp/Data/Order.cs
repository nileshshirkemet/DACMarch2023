namespace DBWebApp.Data;

using System.ComponentModel.DataAnnotations.Schema;

[Table("OrderDetail")]
public class Order
{
    [Column("OrderNo")]
    public int Id { get; set; }

    public DateTime OrderDate { get; set; }

    public string CustomerId { get; set; }

    public int ProductNo { get; set; }

    public int Quantity { get; set; }
}

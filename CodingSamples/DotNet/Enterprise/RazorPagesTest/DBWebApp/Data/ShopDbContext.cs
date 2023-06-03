using Microsoft.EntityFrameworkCore;

namespace DBWebApp.Data;

public class ShopDbContext : DbContext
{
    public DbSet<Customer> Customers { get; set; }

    public DbSet<Order> Orders { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlServer("Data Source=iitdac.met.edu;Encrypt=False;Database=Shop1;User ID=dac1;Password=Dac1@1234");
    }
}

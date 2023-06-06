using Microsoft.EntityFrameworkCore;

namespace ServerApp.Shopping;

public class ShopDbContext : DbContext
{
    public DbSet<Counter> Counters { get; set; }

    public DbSet<Order> Orders { get; set; }

    protected override void OnConfiguring(DbContextOptionsBuilder optionsBuilder)
    {
        optionsBuilder.UseSqlServer("Data Source=iitdac.met.edu;Encrypt=False;Database=Shop1;User ID=dac1;Password=Dac1@1234");
    }

    protected override void OnModelCreating(ModelBuilder modelBuilder)
    {
        modelBuilder.Entity<Order>()
            .ToTable("OrderDetail")
            .Property(e => e.Id)
            .HasColumnName("OrderNo");
        modelBuilder.Entity<Order>()
            .Property(e => e.ProductId)
            .HasColumnName("ProductNo");
    }
}
using Sales;
using Grpc.Core;

namespace ServerApp.Shopping;

public class OrderManagerService : OrderManager.OrderManagerBase
{
    public override async Task<OrderStatus> PlaceOrder(OrderInput request, ServerCallContext context)
    {
        var reply = new OrderStatus();
        var shop = new ShopDbContext();
        var ctr = await shop.Counters.FindAsync("order");
        var order = new Order 
        {
            Id = ++ctr.CurrentValue + ctr.SeedValue,
            OrderDate = DateTime.Today,
            CustomerId = request.CustomerCode,
            ProductId = request.ItemCode,
            Quantity = request.ItemCount
        };
        shop.Orders.Add(order);
        try
        {
            await shop.SaveChangesAsync();
            reply.ConfirmationCode = order.Id;
        }
        catch(Exception ex)
        {
            Console.WriteLine(ex);
            context.Status = new Status(StatusCode.Internal, "Order Failed");
        }
        return reply;
    }

    public override async Task FetchOrders(CustomerInput request, IServerStreamWriter<CustomerOrder> responseStream, ServerCallContext context)
    {
        var shop = new ShopDbContext();
        var selection = from e in shop.Orders
                        where e.CustomerId == request.CustomerCode
                        select new CustomerOrder 
                        {
                            ItemCode = e.ProductId,
                            ItemCount = e.Quantity,
                            ConfirmationDate = e.OrderDate.ToString("yyyy-MM-dd")
                        };
        foreach(var entry in selection)
            await responseStream.WriteAsync(entry);
    }
}
using Sales;
using Grpc.Core;
using Microsoft.AspNetCore.Mvc;

namespace RESTWebApp.Controllers;

[ApiController]
[Route("/api/sales")]
public class SalesAgentController : ControllerBase
{
    [HttpGet("{id}")]
    public async Task<ActionResult<List<OrderResource>>> ReadOrdersAsync(string id, OrderManager stub)
    {
        try
        {
            var request = new CustomerInput { CustomerCode = id };
            using var reply = stub.FetchOrders(request);
            var orders = await reply.ResponseStream.ReadAllAsync()
                            .Select(msg => new OrderResource 
                            {
                                ProductNo = msg.ItemCode,
                                Quantity = msg.ItemCount,
                                OrderDate = msg.ConfirmationDate
                            })
                            .ToListAsync();
            if(orders.Count > 0)
                return orders;
            return NotFound();
        }
        catch(Exception ex)
        {
            Console.WriteLine(ex);
            return StatusCode(500);
        }
    }

    [HttpPost]
    public async Task<ActionResult<OrderResource>> CreateOrderAsync(OrderResource detail, OrderManager stub)
    {
        try
        {
            var request = new OrderInput 
            {
                CustomerCode = detail.CustomerId,
                ItemCode = detail.ProductNo,
                ItemCount = detail.Quantity
            };
            var reply = await stub.PlaceOrderAsync(request);
            detail.OrderNo = reply.ConfirmationCode;
            return detail;
        }
        catch(Exception ex)
        {
            Console.WriteLine(ex);
            return StatusCode(500);
        }
    }
}

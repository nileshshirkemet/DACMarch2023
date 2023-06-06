package rest.web.app;

import shopping.*;
import java.rmi.*;
import java.util.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

@Path("/sales")
public class SalesAgentService {

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response readOrders(@PathParam("id") String customerId) {
		try{
			var stub = (OrderManager)Naming.lookup("rmi://localhost:4030/orderManagement");
			var orders = stub.fetchOrders(customerId);
			if(orders.size() > 0)
				return Response.ok(orders).build();
			return Response.status(404).build();
		}catch(Exception e){
			return Response.status(500).build();
		}
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createOrder(OrderEntity order) {
		try{
			var stub = (OrderManager)Naming.lookup("rmi://localhost:4030/orderManagement");
			int orderNo = stub.placeOrder(order);
			order.setOrderNo(orderNo);
			return Response.ok(order).build();	
		}catch(Exception e){
			return Response.status(500).build();
		}
	}
}


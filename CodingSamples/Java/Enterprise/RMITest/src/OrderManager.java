package shopping;

import java.rmi.*;
import java.util.*;

public interface OrderManager extends Remote {
	int placeOrder(OrderEntity order) throws RemoteException;
	List<OrderEntity> fetchOrders(String customerId) throws RemoteException;
}


package shopping;

import java.rmi.*;
import java.util.*;
import jakarta.persistence.*;

public class OrderManagerService extends java.rmi.server.UnicastRemoteObject implements OrderManager {

	public OrderManagerService(int port) throws RemoteException {
		super(port); //exports this object on the specified port
	}

	public int placeOrder(OrderEntity order) throws RemoteException {
		var emf = Persistence.createEntityManagerFactory("Shop");
		try(var em = emf.createEntityManager()){
			var tx = em.getTransaction();
			tx.begin();
			var ctr = em.find(CounterEntity.class, "orders");
			int orderNo = ctr.getNextValue() + 1000;
			order.setOrderNo(orderNo);
			order.setOrderDate(new Date());
			em.persist(order);
			tx.commit(); //any exception will automatically rollback tx
			return orderNo;
		}
	}

	public List<OrderEntity> fetchOrders(String customerId) throws RemoteException {
		var emf = Persistence.createEntityManagerFactory("Shop");
		try(var em = emf.createEntityManager()){
			var query = em.createQuery("SELECT e FROM OrderEntity e WHERE e.customerId=?1", OrderEntity.class);
			query.setParameter(1, customerId);
			return query.getResultList();
		}
	}

}


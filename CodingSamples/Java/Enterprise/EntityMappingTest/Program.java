import shopping.*;
import jakarta.persistence.*;

class Program {

	public static void main(String[] args) throws Exception {
		var emf = Persistence.createEntityManagerFactory("Shop");
		var em = emf.createEntityManager();
		if(args.length == 0){
			var query =em.createQuery("SELECT e FROM ProductEntity e WHERE e.stock > 0", ProductEntity.class);
			var products = query.getResultList();
			for(var entry : products){
				System.out.printf("%d\t%.2f\t%d%n", entry.getProductNo(), entry.getPrice(), entry.getStock());
			}
		}else{
			int productNo = Integer.parseInt(args[0]);
			var product = em.find(ProductEntity.class, productNo);
			if(product != null){
				var orders = product.getOrders();
				for(var entry : orders){
					System.out.printf("%s\t%d\t%tF%n", entry.getCustomerId(), entry.getQuantity(), entry.getOrderDate());
				}
			}
		}
		em.close();
	}
}



package shopping;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "products")
public class ProductEntity implements java.io.Serializable {

	@Id
	@Column(name="pno")
	private int productNo;

	@Column(name="price")
	private double price;

	@Column(name="stock")
	private int stock;

	@OneToMany
	@JoinColumn(name = "pno")
	private List<OrderEntity> orders;

	public int getProductNo() { return productNo; }
	public void setProductNo(int value) { productNo = value; }

	public double getPrice() { return price; }
	public void setPrice(double value) { price = value; }

	public int getStock() { return stock; }
	public void setStock(int value) { stock = value; }

public List<OrderEntity> getOrders() { return orders; }
	public void setOrders(List<OrderEntity> value) { orders = value; }

}


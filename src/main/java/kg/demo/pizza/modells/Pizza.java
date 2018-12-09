package kg.demo.pizza.modells;

import javax.persistence.*;

@Entity
@Table(name = "pizzas")
public class Pizza {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private Float price;
	@ManyToOne
	@JoinColumn(name = "order_id")
	private Order order;

	public Pizza() {
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Float getPrice() {
		return price;
	}

	public Order getOrder() {
		return order;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
}

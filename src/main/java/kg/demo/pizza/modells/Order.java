package kg.demo.pizza.modells;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private int count;
	@OneToMany(mappedBy = "order", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Pizza> pizzas;

	public Order() {
	}

	public long getId() {
		return id;
	}

	public int getCount() {
		return count;
	}

	public List<Pizza> getPizzas() {
		return pizzas;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void setPizzas(List<Pizza> pizzas) {
		this.pizzas = pizzas;
	}
}

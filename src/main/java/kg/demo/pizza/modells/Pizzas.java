package kg.demo.pizza.modells;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Pizzas {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    public String name;
    private Float price;
    @ManyToOne(fetch=FetchType.LAZY, cascade = {CascadeType.MERGE})
    private List<Orders> orders=new ArrayList<>();

    public List<Orders> getOrders() {
        return orders;
    }


    public Pizzas(String name, Float price) {
        this.name = name;
        this.price = price;
    }

    public Pizzas() {
    }

    public void addOrders(Orders order){
        orders.add(order);
        order.setPizzas(this);
    }
    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}

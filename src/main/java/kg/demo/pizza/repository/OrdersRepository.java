package kg.demo.pizza.repository;

import kg.demo.pizza.modells.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository<Order, Long> {
}

package kg.demo.pizza.repository;

import kg.demo.pizza.modells.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepository extends JpaRepository <Orders, Long> {
}

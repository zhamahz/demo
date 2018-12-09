package kg.demo.pizza.repository;


import kg.demo.pizza.modells.Pizzas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzasRepository extends JpaRepository <Pizzas, Long>{
}

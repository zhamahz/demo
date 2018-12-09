package kg.demo.pizza;

import kg.demo.pizza.modells.Pizza;
import kg.demo.pizza.repository.PizzasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@SpringBootApplication
public class PizzaApplication {

	@Autowired
	private PizzasRepository pizzasRepository;

	public static void main(String[] args) {
		SpringApplication.run(PizzaApplication.class, args);
	}

	@PostConstruct
	public void createData() {
		Pizza pizza = new Pizza();
		pizza.setName("4 Сезона");
		pizza.setPrice(380f);
		pizzasRepository.save(pizza);

		pizza = new Pizza();
		pizza.setName("Гавайская");
		pizza.setPrice(400f);
		pizzasRepository.save(pizza);

		pizza = new Pizza();
		pizza.setName("Итальянская");
		pizza.setPrice(300f);
		pizzasRepository.save(pizza);

		pizza = new Pizza();
		pizza.setName("Маргарита");
		pizza.setPrice(290f);
		pizzasRepository.save(pizza);

		pizza = new Pizza();
		pizza.setName("Мексиканская");
		pizza.setPrice(350f);
		pizzasRepository.save(pizza);

		pizza = new Pizza();
		pizza.setName("Морская");
		pizza.setPrice(370f);
		pizzasRepository.save(pizza);

		pizza = new Pizza();
		pizza.setName("Мясная");
		pizza.setPrice(400f);
		pizzasRepository.save(pizza);

		pizza = new Pizza();
		pizza.setName("Пепперони");
		pizza.setPrice(350f);
		pizzasRepository.save(pizza);

		pizza = new Pizza();
		pizza.setName("Сальса");
		pizza.setPrice(380f);
		pizzasRepository.save(pizza);

		pizza = new Pizza();
		pizza.setName("Сырная");
		pizza.setPrice(250f);
		pizzasRepository.save(pizza);
	}

	@PreDestroy
	public void clearData() {
		pizzasRepository.deleteAll();
	}
}

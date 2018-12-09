package kg.demo.pizza.configuration;

import kg.demo.pizza.modells.Pizzas;
import kg.demo.pizza.modells.Client;
import kg.demo.pizza.repository.ClientRepository;
import kg.demo.pizza.repository.PizzasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);
    @Autowired
    private ClientRepository clientRepository;
    @Autowired
    private PizzasRepository pizzasRepository;
    @Bean
    public PasswordEncoder pEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Override
    public void run(String... args) {
        log.info("Create clients");
        Client client = new Client();
        Set<Client> rl = new HashSet<Client>();
        client.setUserName("Admin");
        client.setActive(1);
        client.setPassword(pEncoder().encode("123456"));
        clientRepository.save(client);

        Pizzas pizzas = new Pizzas();
        pizzas.setName("4 Сезона");
        pizzas.setPrice(380f);
        pizzasRepository.save(pizzas);
        pizzas = new Pizzas();
        pizzas.setName("Гавайская");
        pizzas.setPrice(400f);
        pizzasRepository.save(pizzas);
        pizzas.setName("Итальянская");
        pizzas.setPrice(300f);
        pizzasRepository.save(pizzas);
        pizzas.setName("Маргарита");
        pizzas.setPrice(290f);
        pizzasRepository.save(pizzas);
        pizzas.setName("Мексиканская");
        pizzas.setPrice(350f);
        pizzasRepository.save(pizzas);
        pizzas.setName("Морская");
        pizzas.setPrice(370f);
        pizzasRepository.save(pizzas);
        pizzas.setName("Мясная");
        pizzas.setPrice(400f);
        pizzasRepository.save(pizzas);
        pizzas.setName("Пепперони");
        pizzas.setPrice(350f);
        pizzasRepository.save(pizzas);
        pizzas.setName("Сальса");
        pizzas.setPrice(380f);
        pizzasRepository.save(pizzas);
        pizzas.setName("Сырная");
        pizzas.setPrice(250f);
        pizzasRepository.save(pizzas);

    }
}

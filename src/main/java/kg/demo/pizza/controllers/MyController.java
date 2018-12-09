package kg.demo.pizza.controllers;

import kg.demo.pizza.modells.Pizzas;
import kg.demo.pizza.repository.OrdersRepository;
import kg.demo.pizza.repository.PizzasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller

public class MyController {
    @Autowired
    private PizzasRepository pizzasRepository;

    @Autowired
    private OrdersRepository ordersRepository;
    @RequestMapping(path = "add")
    public @ResponseBody
    String AddNewPizza(@RequestParam String name, @RequestParam Float price){
//        Pizzas p=new Pizzas();
//        p.setPrice(price);
//        p.setName(name);
//        pizzasRepository.save(p);

        return  "Saved";
    }

    @RequestMapping(path = "/all")
    public @ResponseBody Iterable<Pizzas> getAll(){
//
//        Pizzas p=new Pizza("Phone", 1545f);
//
//        Orders ord=new Orders(10);
//        Orders ord2=new Orders(15);
//        p.addOrders(ord);
//        p.addOrders(ord2);
//
//        pizzasRepository.save(p);
//        ordersRepository.save(ord);
//        ordersRepository.save(ord2);

        return   pizzasRepository.findAll();
    }
}

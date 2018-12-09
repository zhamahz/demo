package kg.demo.pizza.controllers;

import kg.demo.pizza.modells.Orders;
import kg.demo.pizza.repository.OrdersRepository;
import kg.demo.pizza.repository.PizzasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class OrdersController {

    @Autowired
    private OrdersRepository ordersRepository;
    @Autowired
    private PizzasRepository pizzasRepository;

    @RequestMapping(value= "/templates/orders/create", method = RequestMethod.GET)
    public ModelAndView newUser(){
        ModelAndView modelAndView = new ModelAndView();
        Orders orders=new Orders();
        modelAndView.addObject("templates/orders", orders);
        modelAndView.addObject("listPizzas", pizzasRepository.findAll());
        modelAndView.setViewName("templates/orders/create");
        return  modelAndView;
    }

    @RequestMapping(value = "/templates/orders/create", method = RequestMethod.POST)
    public ModelAndView saveTipZavedinia(@Valid Orders orders, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        try {
            if (bindingResult.hasErrors()) {
                modelAndView.setViewName("templates/orders/create");
            } else {
                ordersRepository.save(orders);
                modelAndView.setViewName("redirect:/orders/index");
            }
            return modelAndView;
        } catch (Exception exp){
            modelAndView.addObject("Error", exp.getMessage());
            modelAndView.addObject("templates/orders", orders);
            modelAndView.addObject("listPizzas", pizzasRepository.findAll());
            modelAndView.setViewName("templates/orders/create");
            return  modelAndView;
        }
    }
    @RequestMapping(value={"templates/orders/index"}, method = RequestMethod.GET)
    public ModelAndView Index(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("templates/orders", ordersRepository.findAll());
        modelAndView.setViewName("templates/orders/index");
        return modelAndView;
    }


}


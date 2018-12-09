package kg.demo.pizza.controllers;

import kg.demo.pizza.configuration.UserRepositoryCommandLineRunner;
import kg.demo.pizza.repository.PizzasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
    private static final Logger log = LoggerFactory.getLogger(UserRepositoryCommandLineRunner.class);

    @Autowired
    private PizzasRepository pizzasRepository;

    @RequestMapping(value={"/login"}, method = RequestMethod.GET)
    public ModelAndView login(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;   }

    @RequestMapping(value={"/"}, method = RequestMethod.GET)
    public ModelAndView welcome() {
        log.info("Called Welcome method");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("pizzas", pizzasRepository.findAll());
        modelAndView.addObject("titles","This is title");
        modelAndView.setViewName("welcome");
        return modelAndView;
    }
}


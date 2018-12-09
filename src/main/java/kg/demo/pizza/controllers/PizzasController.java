package kg.demo.pizza.controllers;

import kg.demo.pizza.modells.Pizza;
import kg.demo.pizza.repository.PizzasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class PizzasController {
	@Autowired
	private PizzasRepository pizzasRepository;

	@RequestMapping(value = {"pizzas/index"}, method = RequestMethod.GET)
	public ModelAndView Index() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pizzas", pizzasRepository.findAll());
		modelAndView.setViewName("pizzas/index");
		return modelAndView;
	}

	@RequestMapping(value = "/pizzas/create", method = RequestMethod.GET)
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView();
		Pizza pizza = new Pizza();
		modelAndView.addObject("pizzas", pizza);
		modelAndView.setViewName("pizzas/create");
		return modelAndView;
	}

	@RequestMapping(value = "/pizzas/create", method = RequestMethod.POST)
	public ModelAndView saveClient(@Valid Pizza pizza, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			if (bindingResult.hasErrors()) {
				modelAndView.setViewName("pizzas/create");
			} else {
				pizzasRepository.save(pizza);
				modelAndView.setViewName("redirect:/pizzas/index");
			}
			return modelAndView;
		} catch (Exception exp) {
			modelAndView.addObject("Error", exp.getMessage());
			modelAndView.addObject("pizzas", pizza);
			modelAndView.setViewName("pizzas/create");
			return modelAndView;
		}
	}


	@RequestMapping(value = "/pizzas/edit/{id}", method = RequestMethod.GET)
	public ModelAndView edit(@PathVariable("id") Long id, Model model) {
		ModelAndView modelAndView = new ModelAndView();
		Pizza product = pizzasRepository.getOne(id);
		modelAndView.addObject("pizzas", product);
		modelAndView.setViewName("pizzas/edit");
		return modelAndView;
	}


	@RequestMapping(value = "pizzas/edit", method = RequestMethod.POST)
	public ModelAndView editPizzas(@ModelAttribute("pizzas") Pizza pizza, BindingResult result, ModelMap model) {
		ModelAndView modelAndView = new ModelAndView();
		if (result.hasErrors()) {
			modelAndView.setViewName("pizzas/edit/" + pizza.getId());
		} else {
			pizzasRepository.save(pizza);
			modelAndView.setViewName("redirect:/pizzas/index");
		}
		return modelAndView;
	}

	@RequestMapping(value = "pizzas/delete/{id}", method = RequestMethod.GET)
	public ModelAndView tipZavedeniaDelete(@PathVariable("id") Long id, Model model) {
		Pizza pizza = pizzasRepository.findById(id).get();

		pizzasRepository.delete(pizza);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/pizzas/index");
		return modelAndView;
	}


}

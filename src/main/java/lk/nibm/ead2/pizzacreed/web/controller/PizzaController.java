package lk.nibm.ead2.pizzacreed.web.controller;

import lk.nibm.ead2.pizzacreed.web.Service.Impl.PizzaService;
import lk.nibm.ead2.pizzacreed.web.model.Pizza;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RequestMapping("/pizza")
@Controller
public class PizzaController {
    @Autowired
    private PizzaService pizzaService;

    @RequestMapping("home")
    public String showHome(){return "home";}

    // Display all pizzas in "pizza" view
    @GetMapping("/showPizza")
    public String showPizza(Model model){
        List<Pizza> listPizza = pizzaService.listAll();
        model.addAttribute("listPizza",listPizza);
        System.out.println("Get / ");
        return "pizza";
    }

    // Add new Pizza
    @GetMapping("/new_pizza")
    public String add(Model model)
    {
        model.addAttribute("pizza", new Pizza());
        return "new_pizza";
    }

    // save pizza
    @RequestMapping(value = "/saves", method = RequestMethod.POST)
    public String savePizza(@ModelAttribute("pizza") Pizza std){
        pizzaService.savePizza(std);
        return "redirect:pizza";
    }

    //edit pizza using id
    @RequestMapping("/edits/{id}")
    public ModelAndView showEditPage(@PathVariable(name = "id") Long id){
        ModelAndView mav = new ModelAndView("new_pizza");
        Pizza std = pizzaService.get(id);
        mav.addObject("pizza",std);
        return mav;
    }

    //delete pizza by id
    @RequestMapping("/deletes/{id}")
    public String deletePizza(@PathVariable(name = "id") Long id){
        pizzaService.deletePizza(id);
        return "home";
    }
}

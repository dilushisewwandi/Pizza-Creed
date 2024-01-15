package lk.nibm.ead2.pizzacreed.web.controller;

import lk.nibm.ead2.pizzacreed.web.model.Pizza;
import lk.nibm.ead2.pizzacreed.web.Service.IPizzaService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PizzaRestController {
    @Autowired
    IPizzaService service;

    //Return pizza list
    @RequestMapping(value="/pizza", method= RequestMethod.GET)
    @ResponseBody
    public List<Pizza> getPizza(){
        return service.findAll();
    }

    //create pizza
    @RequestMapping(value="/pizza", method= RequestMethod.POST)
    @ResponseBody
    public Pizza createPizza(@RequestBody Pizza pizza){
        return service.save(pizza);
    }

    //update pizza
    @RequestMapping(value="/pizza/{id}", method= RequestMethod.PUT)
    @ResponseBody
    public Pizza updatePizza(@PathVariable Long id,@RequestBody Pizza pizza){
        pizza.setId(id);
        return service.save(pizza);
    }

    //get pizza by id
    @RequestMapping(value = "/pizza/{id}",method = RequestMethod.GET)
    @ResponseBody
    public Pizza findPizza(@PathVariable Long id){
        return service.find(id);
    }

    //delete pizza by id
    @RequestMapping(value="/pizza/{id}", method= RequestMethod.DELETE)
    @ResponseBody
    public boolean deletePizza(@PathVariable Long id){
        return service.delete(id);
    }
}

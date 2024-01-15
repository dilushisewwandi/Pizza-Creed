package lk.nibm.ead2.pizzacreed.web.Service.Impl;

import lk.nibm.ead2.pizzacreed.web.Service.IPizzaService;
import lk.nibm.ead2.pizzacreed.web.model.Pizza;
import lk.nibm.ead2.pizzacreed.web.repository.PizzaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PizzaService implements IPizzaService {
    @Autowired
    private PizzaRepository pizzaRepository;

    //method for rest controller for save pizza
    @Override
    public Pizza save(Pizza pizza) {
        Pizza dto;

        if (pizza.getId() == null) {
            dto = new Pizza();
        } else {
            Optional<Pizza> optPizza = pizzaRepository.findById(pizza.getId());
            dto = optPizza.orElse(new Pizza()); // If not present, create a new Pizza
        }

        BeanUtils.copyProperties(pizza, dto);
        dto = pizzaRepository.save(dto);

        // Optionally, update the ID in the original pizza object
        pizza.setId(dto.getId());

        return pizza;
    }



    //method for rest controller for find all pizza
    @Override
    public List<Pizza> findAll() {
        List<Pizza> pizza= pizzaRepository.findAll();
        return pizza.stream().map( s -> {
            Pizza dto = new Pizza();
            BeanUtils.copyProperties(s,dto);
            return dto;
        }).collect(Collectors.toList());
    }

    //method for rest controller for find pizza by id
    @Override
    public Pizza find(Long id){
        Optional<Pizza> optPizza= pizzaRepository.findById(id);
        if(optPizza.isPresent()){
            Pizza dto = new Pizza();
            BeanUtils.copyProperties(optPizza.get(),dto);
            return dto;
        }
        return null;
    }

    //method for rest controller for delete pizza
    @Override
    public Boolean delete(Long id){
        Optional<Pizza> optPizza= pizzaRepository.findById(id);
        if(optPizza.isPresent()){
            pizzaRepository.delete(optPizza.get());
        }
        else{
            return Boolean.FALSE;
        }
        return Boolean.TRUE;
    }

    //method for list all pizza in GUI Table
    public List<Pizza> listAll(){
        return pizzaRepository.findAll();
    }
    public Pizza get(long id){
        return pizzaRepository.findAllById(Collections.singleton(id)).get(0);
    }
    public void deletePizza(long id){pizzaRepository.deleteById(id);}
    public void savePizza(Pizza std){pizzaRepository.save(std);}
}


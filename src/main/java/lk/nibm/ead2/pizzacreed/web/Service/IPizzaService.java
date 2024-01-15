package lk.nibm.ead2.pizzacreed.web.Service;
import lk.nibm.ead2.pizzacreed.web.model.Pizza;
import java.util.List;

public interface IPizzaService {
    Pizza save(Pizza pizza);
    List<Pizza> findAll();
    Boolean delete(Long id);
    Pizza find(Long id);
}

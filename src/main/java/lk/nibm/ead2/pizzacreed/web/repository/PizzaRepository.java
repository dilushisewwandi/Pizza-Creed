package lk.nibm.ead2.pizzacreed.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import lk.nibm.ead2.pizzacreed.web.model.Pizza;
@Repository
public interface PizzaRepository extends JpaRepository<Pizza,Long> {
}

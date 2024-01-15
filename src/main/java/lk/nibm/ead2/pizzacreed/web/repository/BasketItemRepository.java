package lk.nibm.ead2.pizzacreed.web.repository;

import lk.nibm.ead2.pizzacreed.web.model.BasketItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BasketItemRepository extends JpaRepository<BasketItem,Long> {
}

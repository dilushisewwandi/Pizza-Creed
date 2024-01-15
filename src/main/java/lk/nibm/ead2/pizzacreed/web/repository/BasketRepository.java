package lk.nibm.ead2.pizzacreed.web.repository;

import lk.nibm.ead2.pizzacreed.web.model.Basket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface BasketRepository extends JpaRepository<Basket, String> {
    Optional<Basket> findById(String id);
}

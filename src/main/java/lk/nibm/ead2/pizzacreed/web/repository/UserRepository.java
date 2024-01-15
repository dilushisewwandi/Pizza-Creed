package lk.nibm.ead2.pizzacreed.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import lk.nibm.ead2.pizzacreed.web.model.User;
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

package lk.nibm.ead2.pizzacreed.web.Service;

import lk.nibm.ead2.pizzacreed.web.model.User;
import java.util.List;

public interface IUserService {
    User findByUsername(String username);
    User save(User user);
}

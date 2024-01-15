package lk.nibm.ead2.pizzacreed.web.Service;

import lk.nibm.ead2.pizzacreed.web.model.Basket;

import java.util.List;

public interface IBasketService {
    Basket createBasket(Basket basket1);
    List <Basket> findallBaskets();
    Basket createBasket();

}

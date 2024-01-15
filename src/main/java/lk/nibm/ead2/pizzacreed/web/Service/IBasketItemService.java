package lk.nibm.ead2.pizzacreed.web.Service;

import lk.nibm.ead2.pizzacreed.web.model.BasketItem;

import java.util.List;

public interface IBasketItemService {
    //save basket items
    String saveBasket(BasketItem basketItem);

    //get all baskets items
    List<BasketItem> getAllBaskets();

    void clearCart();

    //delete basket item by id
    boolean deleteBasketById(Long basketId);

    //delete all basket item
    boolean deleteAllBasketItems();
}

package lk.nibm.ead2.pizzacreed.web.Service.Impl;

import lk.nibm.ead2.pizzacreed.web.Service.IBasketService;
import lk.nibm.ead2.pizzacreed.web.model.Basket;
import lk.nibm.ead2.pizzacreed.web.repository.BasketRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BasketService implements IBasketService {
    @Autowired
    private BasketRepository basketRepository;

    //create new basket method 01
    @Override
    public Basket createBasket(Basket basket1) {
    Basket createdBasket = basketRepository.save(basket1);
    //return createdBasket.getId();
    return createdBasket;
}

    //create new basket method 02
    @Override
    public Basket createBasket() {
        Basket basket = new Basket();
        return basketRepository.save(basket);
    }
    //read all baskets
    @Override
    public List<Basket> findallBaskets() {
        return basketRepository.findAll();
    }

}


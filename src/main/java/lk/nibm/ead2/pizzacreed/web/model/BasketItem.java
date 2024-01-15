package lk.nibm.ead2.pizzacreed.web.model;

import jakarta.persistence.*;

@Entity
@Table(name="BASKET_ITEM")
public class BasketItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="Quantity")
    private Long quantity;

    @Column(name = "Pizza_ID")
    private Long Pizza_ID;

    @ManyToOne
    private Basket basket;
//    @ManyToOne
//    private Pizza pizza;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        quantity = quantity;
    }

    public Long getPizza_ID() {
        return Pizza_ID;
    }

    public void setPizza_ID(Long pizza_ID) {Pizza_ID=pizza_ID;}

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

}

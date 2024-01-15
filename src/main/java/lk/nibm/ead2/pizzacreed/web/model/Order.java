package lk.nibm.ead2.pizzacreed.web.model;

import jakarta.persistence.*;

@Entity
@Table(name="ORDERS")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="Price")
    private Double Price;
//    @ManyToOne
//    private Basket basket;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {
        Price = price;
    }

//    public Basket getBasket() {
//        return basket;
//    }
//
//    public void setBasket(Basket basket) {
//        this.basket = basket;
//    }
}

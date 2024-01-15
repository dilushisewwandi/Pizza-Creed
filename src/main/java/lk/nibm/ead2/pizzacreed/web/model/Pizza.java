package lk.nibm.ead2.pizzacreed.web.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="PIZZA")
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    private Long id;
    @Column(name="Name")
    private  String Name ;
    @Column(name="Size")
    private String Size;
    @Column(name="Price")
    private Double Price;

//    @OneToMany(mappedBy = "pizza")
//    private List<BasketItem> basketItems;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSize() {return Size;}

    public void setSize(String size) {
        Size = size;
    }

    public Double getPrice() {
        return Price;
    }

    public void setPrice(Double price) {Price = price;}

//    public List<BasketItem> getBasketItems() {
//        return basketItems;
//    }
//
//    public void setBasketItems(List<BasketItem> basketItems) {
//        this.basketItems = basketItems;
//    }
}

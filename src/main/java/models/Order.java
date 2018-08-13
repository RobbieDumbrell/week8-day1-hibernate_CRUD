package models;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    private int id;
    private String pizzaType;
    private int quantity;

    public Order() {

    }

    public Order(String pizzaType, int quantity) {
        this.pizzaType = pizzaType;
        this.quantity = quantity;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "pizza_type")
    public String getPizzaType() {
        return pizzaType;
    }

    public void setPizzaType(String pizzaType) {
        this.pizzaType = pizzaType;
    }

    @Column(name = "quantity")
    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

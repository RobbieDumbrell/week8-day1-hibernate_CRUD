import db.DBCustomer;
import db.DBOrder;
import models.Customer;
import models.Order;

import java.util.List;

public class Runner {

    public static void main(String[] args) {

        Customer customer1 = new Customer("Ellie", "White", 25);
        Customer customer2 = new Customer("Robbie", "Dumbrell", 25);
        Customer customer3 = new Customer("James", "Bond", 40);
        Customer customer4 = new Customer("David", "Beckham", 38);
        Order order1 = new Order("Pepperoni", 4);
        Order order2 = new Order("Margherita", 2);
        Order order3 = new Order("Meat Feast", 8);

        DBCustomer.save(customer1);
        DBCustomer.save(customer2);
        DBCustomer.save(customer3);
        DBCustomer.save(customer4);
        DBOrder.save(order1);
        DBOrder.save(order2);
        DBOrder.save(order3);

        List<Customer> allCustomers = DBCustomer.getAll();
        List<Order> allOrders = DBOrder.getAll();

        Customer foundCustomer = DBCustomer.findById(2);
        Order foundOrder = DBOrder.findById(2);

        foundCustomer.setAge(26);
        DBCustomer.update(foundCustomer);

        foundOrder.setQuantity(37);
        DBOrder.update(foundOrder);

        DBCustomer.delete(foundCustomer);
        DBOrder.delete(foundOrder);

    }
}

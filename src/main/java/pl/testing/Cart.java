package pl.testing;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    private List<Order> orders = new ArrayList<>();

    public void addOrderToCart(Order order){
        orders.add(order);
    }
    public void clearCaet (){
        this.orders.clear();
    }

    public void simulateLargeOrder(){

        for(int i = 0; i< 1000; i++){

            Meal meal = new Meal("Burger", 20.00);
            Order order = new Order();
            order.addMealToOrder(meal);
            addOrderToCart(order);

        }
        System.out.println("Carts sizxe: " + orders.size());
        clearCaet();
    }

    public List<Order> getOrders() {
        return orders;
    }
}

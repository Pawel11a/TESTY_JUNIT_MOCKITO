package pl.testing;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.junit.jupiter.api.Test;

public class OrderBackUpTest {

    private static OrderBackUp orderBackUp;

    @BeforeAll
    static void setup() throws FileNotFoundException {
        System.out.println("BEFORE-ALL");
        orderBackUp = new OrderBackUp();
        orderBackUp.createFile();
    }

    @Test
    void backUpOrder() throws IOException {
        //given
        Meal meal = new Meal("Frytki", 2.00);
        Order order = new Order();
        order.addMealToOrder(meal);
        //when
        orderBackUp.backUpOrder(order);
        //then
        System.out.println("Order: " + order.toString() + "backend up.");
    }

    @AfterAll
    static void teatrDown() throws IOException {
        System.out.println("AFTER-ALL");
        orderBackUp.closeFile();
    }

}

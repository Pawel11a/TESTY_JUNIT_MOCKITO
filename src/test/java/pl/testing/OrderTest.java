package pl.testing;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class OrderTest {

    private Order order;

    @BeforeEach // - metoda uruchamiana przed każdym testem
    void initializeOrder(){
        System.out.println("Inside @BeforeEach method");
        order = new Order();
    }

    @AfterEach // - metoda uruchamiana po każdym testem
    void cleanUp(){
        System.out.println("Inside @AfterEach method");
        order.cancel();
    }

    //uruchomienie kodu przed wszystkimi testami, uruchomienie metody po wykonaniu wszystkich testów.



    @Test
    void testAssertArrayEquals() {
        //given
        int[] ints1 = {1, 2, 3};
        int[] ints2 = {1, 2, 3};

        //then
        assertArrayEquals(ints1, ints2);
    }

    @Test
    void mealListShouldBeEmptyAfterCreationOfOrder() {


        assertThat(order.getMeals(), empty());
        assertThat(order.getMeals().size(), equalTo(0));
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), emptyCollectionOf(Meal.class));
    }

    @Test
    void addingMealToOrderShouldIncreaseOrderSize() {

        Meal meal = new Meal("Burger", 15.00);
        Meal meal2 = new Meal("Burger2", 11.00);


        order.addMealToOrder(meal);
        order.addMealToOrder(meal2);

        assertThat(order.getMeals(), hasSize(2));
//        assertThat(order.getMeals(), contains(meal));
//        assertThat(order.getMeals(), hasItem(meal));

        assertThat(order.getMeals().get(0).getPrice(), equalTo(15.00));
        assertThat(order.getMeals(), containsInAnyOrder(meal2, meal));
    }

    @Test
    void removingMealToOrderShouldIncreaseOrderSize() {

        Meal meal = new Meal("Burger", 15.00);


        order.addMealToOrder(meal);
        order.removeMealFromOrder(meal);
        assertThat(order.getMeals(), hasSize(0));
        assertThat(order.getMeals(), not(contains(meal)));
    }
}

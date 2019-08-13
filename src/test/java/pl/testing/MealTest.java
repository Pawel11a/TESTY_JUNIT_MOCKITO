package pl.testing;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.lessThan;
import static org.junit.jupiter.api.Assertions.*;

public class MealTest {

    @Tag("soup") // filtrowanie testu po tagach (wykonane są testy z podanym tagiem trzeba dodać w konfiguracji
    @Test
    void exceptionShouldBeThrownIfDiscountIsHigherThanThePrice(){

        Meal meal = new Meal("Soup", 8.00);

        assertThrows(IllegalArgumentException.class, () -> meal.getDiscountPrice(12.00));
    }

@ParameterizedTest //testy z parametrami
@ValueSource(ints = {5,10,15,18}) //te paramtery po koleji będą sprawdzane
//MethodSource("meyhodTest")
//CscSource({"Fabryka 1","Dluga 5"}) - zestawy wartosci
    void mealPriceShouldBeLowerThan20(int price){

     assertThat(price, lessThan(20));
    }


}

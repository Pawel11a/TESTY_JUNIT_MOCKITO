package pl.testing;

import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import java.time.Duration;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyCollectionOf;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.AnyOf.anyOf;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.jupiter.api.Assertions.*;

class CartTest {

    @DisplayName("My simulateLargeOrder method")
    @Test
    void simulateLargeOrder() {
//        @Disabled - wyłączenie testu lub wszystkich testów w klasie jeśli nad klasą
//        @DisplayName - nazwa która będzie wyświetlona gdy test jest uruchomiony (nad klasą lub metodą)
        //given
        Cart cart = new Cart();
        //when then
        assertTimeout(Duration.ofMillis(20), cart::simulateLargeOrder); //10 milisekund
    }

    @Test
    void cartShouldNotBeEmptyAfterAddingOrder() {

        //given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);

        //then
        assertThat(cart.getOrders(), anyOf(//przynajmniej jeden musi przejsc
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertThat(cart.getOrders(), allOf(//wszystkie musza przejsc, pierwszy błąd zostanie wypisany
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))
        ));

        assertAll( //wszystkie metody muszą być spełnione, wszystkie błędy zostaną wypisane
                () -> assertThat(cart.getOrders(), notNullValue())
        );

    }


}
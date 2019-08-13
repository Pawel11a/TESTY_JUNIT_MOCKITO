package pl.testing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumingThat;

public class AccountTest {

    @Test
    void newAccountShouldBeNotActiveAfterCreate(){
        //given
        //when
        Account account = new Account();
        //then
        Assertions.assertFalse(account.isActivate(), "Check if new account is not acctive");
    }

    @Test
    void accountShouldBeActiveAfterAcctivation(){
        //given
        Account account = new Account();
        //when
        account.activate();
        //then
        assertTrue(account.isActivate());
    }

    //    Assumptions i adnotacja @RepeatedTest

    @RepeatedTest(25) //-> powtarza test tyle razy ile wpiszemy
    void newAccountWithNotNullAddressShouldBeActive(){
        //given
        Address address = new Address("Warsaw","Długa");

        //when
        Account account = new Account(address);

        //then
        assumingThat(address != null, () -> { //jeśli warunek spełniony to sprawdza test
            assertTrue(account.isActivate());

        });

    }

}

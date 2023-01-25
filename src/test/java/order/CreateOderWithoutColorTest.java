package order;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static order.OrderClient.*;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateOderWithoutColorTest {

    @Before
    public void setUp() {
        setUpOrderAPI();
    }

    @Test
    @DisplayName("Проверка создания заказа без указания цвета")
    public void createOrderWithoutColor() {
        createOrder(orderWithoutColor)
                .then()
                .statusCode(201)
                .and()
                .assertThat().body("track", notNullValue());
    }

}

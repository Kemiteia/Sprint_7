package Order;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static Order.OrderClient.*;
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
                .assertThat().body("track", notNullValue())
                .and()
                .statusCode(201);
    }

}
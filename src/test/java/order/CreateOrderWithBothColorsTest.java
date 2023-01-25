package order;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static order.OrderClient.*;
import static org.hamcrest.CoreMatchers.notNullValue;

public class CreateOrderWithBothColorsTest {
    @Before
    public void setUp() {
        setUpOrderAPI();
    }

    @Test
    @DisplayName("Проверка создания заказа с двумя цветами")
    public void createOrderWithBothColors() {
        createOrder(orderBothColors)
                .then()
                .statusCode(201)
                .and()
                .assertThat().body("track", notNullValue());
    }
}

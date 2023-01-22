package Order;

import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;

import static Order.OrderClient.*;
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
                .assertThat().body("track", notNullValue())
                .and()
                .statusCode(201);
    }
}

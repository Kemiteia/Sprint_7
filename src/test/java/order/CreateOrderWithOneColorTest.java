package order;

import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static order.OrderClient.*;
import static org.hamcrest.CoreMatchers.notNullValue;

@RunWith(Parameterized.class)
public class CreateOrderWithOneColorTest {
    private final Order order;

    public CreateOrderWithOneColorTest(Order order) {
        this.order = order;
    }

    @Parameterized.Parameters(name = "{index}: color = {0}")
    public static Object[][] getTextData() {
        return new Object[][] {
                {orderBlackColor},
                {orderGreyColor}
        };
    }

    @Test
    @DisplayName("Проверка создания заказа с разными цветами")
    @Description("Параметризованный тест для заказа самоката цвета BLACK или GREY")
    public void createOrderWithOneColor() {
        createOrder(order)
                .then()
                .statusCode(201)
                .and()
                .assertThat().body("track", notNullValue());
    }
}

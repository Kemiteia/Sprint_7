package courier;

import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;

import static courier.CourierClient.*;
import static org.hamcrest.Matchers.equalTo;

public class DuplicateCourierTest {

    @Before
    public void setUp() {
        setUpAPI();
    }

    @Test
    @DisplayName("Проверка создания дубликата уже существующего курьера")
    @Description("Нельзя создать двух одинаковых курьеров. В ответ должно придти сообщение об ошибке 'Этот логин уже используется. Попробуйте другой.' и статус-код 409")
    public void createDuplicateCourier() {
        createCourier(courierSasha)
                .then()
                .statusCode(409)
                .and()
                .assertThat().body("message", equalTo("Этот логин уже используется. Попробуйте другой."));
    }

}

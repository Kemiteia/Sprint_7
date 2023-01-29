package courier;

import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;

import static courier.CourierClient.*;

public class LoginCourierTest {

    @Before
    public void setUp() {
        setUpAPI();
    }

    @Test
    @DisplayName("Проверка авторизации курьера")
    @Description("Курьер может авторизоваться. В ответ приходит id курьера. Статус-код 200")
    public void loginCourier() {
        createCourier(courierSasha);
        authCourier(courierSasha)
                .then()
                .statusCode(200)
                .log().all();
    }
}

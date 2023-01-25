package courier;

import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;

import static courier.CourierClient.*;
import static org.hamcrest.Matchers.equalTo;

public class NotExistUserAuthTest {

    private final Courier courier = new Courier("dfhjhsb", "1111", "Masha");

    @Before
    public void setUp() {
        setUpAPI();
    }

    @Test
    @DisplayName("Проверка авторизации под несуществующим пользователем")
    @Description("Если авторизоваться под несуществующим пользователем, запрос возвращает ошибку 'Учетная запись не найдена' и статус-код 404")
    public void NotExistUserAuth() {
        authCourier(courier)
                .then()
                .statusCode(404)
                .and()
                .assertThat().body("message", equalTo("Учетная запись не найдена"));
    }
}

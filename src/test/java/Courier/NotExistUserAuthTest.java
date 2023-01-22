package Courier;

import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;

import static Courier.CourierClient.*;
import static org.hamcrest.Matchers.equalTo;

public class NotExistUserAuthTest {

    @Before
    public void setUp() {
        setUpAPI();
    }

    @Test
    @DisplayName("Проверка авторизации под несуществующим пользователем")
    @Description("Если авторизоваться под несуществующим пользователем, запрос возвращает ошибку 'Учетная запись не найдена' и статус-код 404")
    public void NotExistUserAuth() {
        notExistUserAuth(courierMasha)
                .then()
                .assertThat().body("message", equalTo("Учетная запись не найдена"))
                .and()
                .statusCode(404);
    }
}

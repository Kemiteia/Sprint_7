package Courier;

import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;

import static Courier.CourierClient.*;
import static org.hamcrest.Matchers.equalTo;

public class NullLoginAuthCourierTest {

    @Before
    public void setUp() {
        setUpAPI();
    }

    @Test
    @DisplayName("Проверка авторизации курьера с пустым логином")
    @Description("Для авторизации нужно передать все обязательные поля. Если какого-то поля нет, запрос возвращает ошибку 'Недостаточно данных для входа' и статус-код 400")
    public void nullLoginAuthCourier() {
        authCourierWithEmptyRequiredField(courierMasha)
                .then()
                .assertThat().body("message", equalTo("Недостаточно данных для входа"))
                .and()
                .statusCode(400);
    }
}

package courier;

import io.qameta.allure.junit4.DisplayName;
import jdk.jfr.Description;
import org.junit.Before;
import org.junit.Test;

import static courier.CourierClient.*;
import static org.hamcrest.Matchers.equalTo;

public class NullPasswordCreateCourierTest {

    @Before
    public void setUp() {
        setUpAPI();
    }

    @Test
    @DisplayName("Проверка создания курьера с пустым паролем")
    @Description("Необходимо передать в ручку все обязательные поля. Если одного из полей нет, запрос возвращает ошибку 'Недостаточно данных для создания учетной записи' и статус-код 400")
    public void nullPasswordCreateCourier() {
        getResponseWithEmptyRequiredField(courierMasha)
                .then()
                .statusCode(400)
                .and()
                .assertThat().body("message", equalTo("Недостаточно данных для создания учетной записи"));
    }
}

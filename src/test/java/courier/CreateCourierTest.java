package courier;

import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static courier.CourierClient.*;
import static org.hamcrest.Matchers.is;

@RunWith(Parameterized.class)
public class CreateCourierTest {

    private final String reqLogin;
    private final String reqPassword;
    private final String reqFirstName;

    public CreateCourierTest(String reqLogin, String reqPassword, String reqFirstName) {
            this.reqLogin = reqLogin;
            this.reqPassword = reqPassword;
            this.reqFirstName = reqFirstName;
    }

    @Parameterized.Parameters(name = "{index}: login = {0},  password = {1}, firstName = {2}")
    public static Object[][] getTextData() {
        return new Object[][] {
                {"ghklj5265", "1111", "Masha"},
                {"jhkl5452", "2222", "Sasha"}
        };
    }

    @Before
    public void setUp() {
        setUpAPI();
    }

    @Test
    @DisplayName("Проверка успешного создания курьера")
    @Description("В ответ приходит сообщение ok и статус-код 201")
    public void createCourierTest() {
        createCourier(new Courier(reqLogin, reqPassword, reqFirstName))
        .then()
                .statusCode(201)
                .and()
                .assertThat()
                .body("ok", is(true));
    }
}

package courier;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class CourierClient {

    public  static final Courier courierMasha = CourierGenerator.getCourierMasha();
    public  static final Courier courierSasha = CourierGenerator.getCourierSasha();

    private static final String LOGIN = "/api/v1/courier/login";
    private static final String PATH = "/api/v1/courier";

    @Step("URI для входа")
    public static void setUpAPI() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

    @Step("Создание курьера")
    public static Response createCourier(Courier courier) {
        return  given()
                .header("Content-type", "application/json")
                .body(courier)
                .post(PATH);
    }

    @Step("Авторизация курьера")
    public static Response authCourier(Courier courier) {
        return  given()
                .header("Content-type", "application/json")
                .body(courier)
                .post(LOGIN);
    }

    @Step("Получение ID курьера")
    public static int getCourierID(Courier courier) {
        return authCourier(courier)
                .body()
                .as(Courier.class).getId();
    }

    @Step("Запрос на удаление")
    public static String courierDeleteAPIStringBuild(int courierID) {
        return PATH + courierID;
    }

    @Step("Удаление курьера")
    public static Response deleteCourier(Courier courier) {
        return  given()
                .header("Content-type", "application/json")
                .delete(
                        courierDeleteAPIStringBuild(
                                getCourierID(courier)
                        ));
    }

    @Step("Создание курьера с пустым паролем")
    public static Response getResponseWithEmptyRequiredField(Courier courier) {
        courier.setPassword(null);
        return  given()
                .header("Content-type", "application/json")
                .body(courier)
                .post(PATH);
    }

}

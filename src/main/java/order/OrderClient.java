package order;

import io.qameta.allure.Step;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class OrderClient {
    public static Order orderBothColors = OrderGenerator.getOrder(getMetroStationId("Кожуховская"));
    public static Order orderWithoutColor = OrderGenerator.getScooterOrderWithoutColor(getMetroStationId("Печатники"));
    public static Order orderBlackColor = OrderGenerator.getBlackScooterOrder(getMetroStationId("Кожуховская"));
    public static Order orderGreyColor = OrderGenerator.getGreyScooterOrder(getMetroStationId("Печатники"));
    private static final String orderCreateAPI = "/api/v1/orders";
    private static final String metroStationAPI = "/api/v1/stations/search";

    @Step("Получить ID станции метро")
    public static String getMetroStationId(String metroName) {
        setUpOrderAPI();
        return given()
                .header("Content-type", "application/json")
                .queryParam("s", metroName)
                .get(metroStationAPI)
                .body()
                .as(MetroStation[].class)[0].getNumber();
    }

    @Step("Создать заказ")
    public static Response createOrder(Order order) {
        return given()
                .header("Content-type", "application/json")
                .body(order)
                .post(orderCreateAPI);
    }

    @Step("Получить список заказов")
    public static Response getOrdersList() {
        return given()
                .header("Content-type", "application/json")
                .get(orderCreateAPI);
    }

    @Step("URI для входа")
    public static void setUpOrderAPI() {
        RestAssured.baseURI = "http://qa-scooter.praktikum-services.ru";
    }

}

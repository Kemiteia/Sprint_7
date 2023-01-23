package order;

import io.qameta.allure.junit4.DisplayName;
import io.restassured.response.Response;
import org.junit.Before;
import org.junit.Test;

import static order.OrderClient.getOrdersList;
import static order.OrderClient.setUpOrderAPI;

public class GetOrdersListTest {

    @Before
    public void setUp() {
        setUpOrderAPI();
    }

    @Test
    @DisplayName("Проверка, что в тело ответа возвращается список заказов")
    public void getOrdersListTest() {

        Response response = getOrdersList();
        response.then().statusCode(200).log().all();

    }
}

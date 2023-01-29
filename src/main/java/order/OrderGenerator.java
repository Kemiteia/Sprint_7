package order;

import java.util.List;

import static order.Colors.BLACK;
import static order.Colors.GREY;

public class OrderGenerator {
    public static Order getOrder(String metroStationID) {
        return new Order("Santa",
                "Claus",
                "Korvatunturi, 267 apt.",
                metroStationID,
                5,
                "2023-06-06",
                "Ho-ho-ho",
                List.of(BLACK.toString(), GREY.toString()));
    }
    public static Order getBlackScooterOrder(String metroStationID) {
        return new Order("Misha",
                "Sidorov",
                "Rahova 56",
                metroStationID,
                5,
                "2023-05-02",
                "No comment",
                List.of(BLACK.toString()));
    }
    public static Order getGreyScooterOrder(String metroStationID) {
        return new Order("Dasha",
                "Petrova",
                "Prospect mira 25",
                metroStationID,
                5,
                "2023-01-29",
                "Nothing",
                List.of(GREY.toString()));
    }
    public static Order getScooterOrderWithoutColor(String metroStationID) {
        return new Order("Igor",
                "Govorun",
                "Patriki",
                metroStationID,
                5,
                "2023-02-09",
                "Hello",
                null);
    }
}

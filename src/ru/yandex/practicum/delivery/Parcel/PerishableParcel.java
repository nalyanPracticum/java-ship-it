package ru.yandex.practicum.delivery.Parcel;

import java.util.Objects;

public class PerishableParcel extends Parcel{

    final static int BASE_PRICE_PERISHABLE = 4;

    public int timeToLive;

    public PerishableParcel(String description, int weight, String deliveryAddress, int sendDay, int timeToLive) {
        super(description, weight, deliveryAddress, sendDay);
        this.timeToLive = timeToLive;
    }

    @Override
    int getBasePrice() {
        return BASE_PRICE_PERISHABLE;
    }

    public boolean isExpired(int currentDay) {
        boolean result = false;
        if ((sendDay + timeToLive) < currentDay) {
            System.out.println("Посылка просрочена!");
            result = true;
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StandardParcel other = (StandardParcel) o;
        return Objects.equals(description, other.description) &&
                (weight == ((StandardParcel) o).weight) &&
                (Objects.equals(deliveryAddress, ((StandardParcel) o).deliveryAddress)) &&
                (sendDay == ((StandardParcel) o).sendDay) &&
                (timeToLive == ((PerishableParcel) o).timeToLive);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, weight, deliveryAddress, sendDay, timeToLive);
    }

}

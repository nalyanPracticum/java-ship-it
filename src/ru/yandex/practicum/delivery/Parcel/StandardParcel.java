package ru.yandex.practicum.delivery.Parcel;

import java.util.Objects;

public class StandardParcel extends Parcel{

    private final static int BASE_PRICE_STANDART = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    int getBasePrice() {
        return BASE_PRICE_STANDART;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        StandardParcel other = (StandardParcel) o;
        return Objects.equals(description, other.description) &&
                (weight == ((StandardParcel) o).weight) &&
                (Objects.equals(deliveryAddress, ((StandardParcel) o).deliveryAddress)) &&
                (sendDay == ((StandardParcel) o).sendDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, weight, deliveryAddress, sendDay);
    }
}

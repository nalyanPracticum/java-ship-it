package ru.yandex.practicum.delivery.Parcel;

import java.util.Objects;

public class FragileParcel extends Parcel implements Trackable {

    private final static int BASE_PRICE_FRAGILE = 3;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    public void packageItem(String description) {
        System.out.printf("\nПосылка <<%s>> обёрнута в защитную плёнку", description);
        super.packageItem(description);
    }

    @Override
    public int getBasePrice() {
        return BASE_PRICE_FRAGILE;
    }

    @Override
    public void reportStatus(String newLocation) {
        System.out.printf("\nХрупкая посылка <<%s>> изменила местоположение на %s", description, newLocation);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || this.getClass() != o.getClass()) return false;
        FragileParcel other = (FragileParcel) o;
        return Objects.equals(description, other.description) &&
                (weight == ((FragileParcel) o).weight) &&
                (Objects.equals(deliveryAddress, ((FragileParcel) o).deliveryAddress)) &&
                (sendDay == ((FragileParcel) o).sendDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(description, weight, deliveryAddress, sendDay);
    }
}

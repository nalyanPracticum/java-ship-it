package ru.yandex.practicum.delivery;

public class StandardParcel extends Parcel{

    final static int BASE_PRICE_STANDART = 2;

    public StandardParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    int getBasePrice() {
        return BASE_PRICE_STANDART;
    }
}

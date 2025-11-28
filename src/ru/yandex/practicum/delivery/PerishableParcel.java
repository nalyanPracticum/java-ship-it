package ru.yandex.practicum.delivery;

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

    boolean isExpired(int currentDay) {
        return (sendDay + timeToLive) < currentDay;
    }

}

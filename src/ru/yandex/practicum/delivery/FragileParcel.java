package ru.yandex.practicum.delivery;

public class FragileParcel extends Parcel{

    final static int BASE_PRICE_FRAGILE = 3;

    public FragileParcel(String description, int weight, String deliveryAddress, int sendDay) {
        super(description, weight, deliveryAddress, sendDay);
    }

    @Override
    void packageItem(String description) {
        System.out.printf("\nПосылка <<%s>> обёрнута в защитную плёнку", description);
        super.packageItem(description);
    }

    @Override
    int getBasePrice() {
        return BASE_PRICE_FRAGILE;
    }
}

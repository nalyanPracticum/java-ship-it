package ru.yandex.practicum.delivery.Parcel;

import java.util.ArrayList;
import java.util.List;

public class ParcelBox<T extends Parcel> {
    public final int maxBoxWeight;
    public List<T> parcelBox = new ArrayList<>();

    public ParcelBox(int maxBoxWeight) {
        this.maxBoxWeight = maxBoxWeight;
    }

    public boolean addParcel(T parcel) {
        boolean isFull = false;
        int totalWeight = 0;
        for (T parcelInBox : parcelBox) {
            totalWeight+= parcelInBox.weight;
        }
        if ((totalWeight + parcel.weight) <= maxBoxWeight) {
            parcelBox.add(parcel);
        } else {
            System.out.println("Превышен максимальный вес посылок в коробке - " + maxBoxWeight +". Посылка в коробку не добавлена!");
            isFull = true;
        }
        return isFull;
    }

    public List<T> getAllParcels(){
        for (T parcel : parcelBox) {
            System.out.println(parcel);
        }
        return parcelBox;
    }
}

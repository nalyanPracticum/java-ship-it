package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.Parcel.FragileParcel;
import ru.yandex.practicum.delivery.Parcel.PerishableParcel;
import ru.yandex.practicum.delivery.Parcel.StandardParcel;

public class DeliveryCostTest {

    @Test
    public void calculateDeliveryStandartParcelIntWeight10() {
        StandardParcel standardParcel = new StandardParcel("description", 10, "adress", 10);
        double actualStandartCost = standardParcel.calculateDeliveryCost();
        Assertions.assertEquals(20, actualStandartCost);
    }

    @Test
    public void calculateDeliveryFragileParcelIntWeight10() {
        FragileParcel fragileParcel = new FragileParcel("description", 10, "adress", 10);
        double actualFragileCost = fragileParcel.calculateDeliveryCost();
        Assertions.assertEquals(30, actualFragileCost);
    }

    @Test
    public void calculateDeliveryPerishableParcelIntWeight10() {
        PerishableParcel perishableParcel = new PerishableParcel("description", 10, "adress", 10, 10);

        double actualPerishableCost = perishableParcel.calculateDeliveryCost();
        Assertions.assertEquals(40, actualPerishableCost);
    }

    @Test
    public void calculateDeliveryStandartParcelIntWeight0() {
        StandardParcel standardParcel = new StandardParcel("description", 0, "adress", 10);
        double actualStandartCost = standardParcel.calculateDeliveryCost();
        Assertions.assertEquals(0, actualStandartCost);
    }

    @Test
    public void calculateDeliveryFragileParcelIntWeight0() {
        FragileParcel fragileParcel = new FragileParcel("description", 0, "adress", 10);
        double actualFragileCost = fragileParcel.calculateDeliveryCost();
        Assertions.assertEquals(0, actualFragileCost);
    }

    @Test
    public void calculateDeliveryPerishableParcelIntWeight0() {
        PerishableParcel perishableParcel = new PerishableParcel("description", 0, "adress", 10, 10);

        double actualPerishableCost = perishableParcel.calculateDeliveryCost();
        Assertions.assertEquals(0, actualPerishableCost);
    }


}

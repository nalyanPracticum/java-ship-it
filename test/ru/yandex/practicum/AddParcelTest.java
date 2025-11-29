package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.Parcel.ParcelBox;
import ru.yandex.practicum.delivery.Parcel.StandardParcel;

public class AddParcelTest {

    static ParcelBox<StandardParcel> standartParcelBox;

    @BeforeEach
    void createBox() {
        standartParcelBox = new ParcelBox<>(40);
    }

    @Test
    void addStandartParcelInBoxEqualsLimit() {
        StandardParcel standardParcel1 = new StandardParcel("description", 10, "adress", 0);
        StandardParcel standardParcel2 = new StandardParcel("description", 30, "adress", 0);

        standartParcelBox.addParcel(standardParcel1);
        standartParcelBox.addParcel(standardParcel2);

        Assertions.assertEquals(standardParcel1, standartParcelBox.getAllParcels().get(0));
        Assertions.assertEquals(standardParcel2, standartParcelBox.getAllParcels().get(1));
    }

    @Test
    void addStandartParcelInBoxMoreLimit() {
        StandardParcel standardParcel1 = new StandardParcel("description", 20, "adress", 0);
        StandardParcel standardParcel2 = new StandardParcel("description", 30, "adress", 0);

        standartParcelBox.addParcel(standardParcel1);
        standartParcelBox.addParcel(standardParcel2);

        Assertions.assertEquals(0, standartParcelBox.getAllParcels().indexOf(standardParcel1));
        Assertions.assertEquals(-1, standartParcelBox.getAllParcels().indexOf(standardParcel2));
    }

    @Test
    void addStandartParcelInBoxLessLimit() {
        StandardParcel standardParcel1 = new StandardParcel("description", 10, "adress", 0);
        StandardParcel standardParcel2 = new StandardParcel("description", 20, "adress", 0);

        standartParcelBox.addParcel(standardParcel1);
        standartParcelBox.addParcel(standardParcel2);

        Assertions.assertEquals(standardParcel1, standartParcelBox.getAllParcels().get(0));
        Assertions.assertEquals(standardParcel2, standartParcelBox.getAllParcels().get(1));
    }
}

package ru.yandex.practicum;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.yandex.practicum.delivery.Parcel.PerishableParcel;

public class IsExpiredTest {

    PerishableParcel perishableParcel = new PerishableParcel("description", 10, "adress", 10, 10);

    @Test
    public void IsExpiredPerishableParcelEquality() {
        boolean actual = perishableParcel.isExpired(20);
        Assertions.assertFalse(actual);
    }

    @Test
    public void IsExpiredPerishableParcelLess() {
        boolean actual = perishableParcel.isExpired(30);
        Assertions.assertTrue(actual);
    }

    @Test
    public void IsExpiredPerishableParcelMore() {
        boolean actual = perishableParcel.isExpired(10);
        Assertions.assertFalse(actual);
    }
}

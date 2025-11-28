package ru.yandex.practicum.delivery.Parcel;

public abstract class Parcel {

    protected String description;
    protected int weight;
    protected String deliveryAddress;
    protected int sendDay;

    public Parcel(String description, int weight, String deliveryAddress, int sendDay) {
        this.deliveryAddress = deliveryAddress;
        this.description = description;
        this.sendDay = sendDay;
        this.weight = weight;
    }

    public void packageItem(String description) {
        System.out.printf("\nПосылка <<%s>> упакована", description);
    }

    public void deliver(String description, String deliveryAddress) {
        System.out.printf("\nПосылка <<%s>> доставлена по адресу %s",description, deliveryAddress);
        System.out.println("\n" + "---".repeat(10));
    }

    abstract int getBasePrice();

    public double calculateDeliveryCost() {
        return weight * getBasePrice();
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Parcel{" +
                "description='" + description + '\'' +
                ", weight=" + weight +
                ", deliveryAddress='" + deliveryAddress + '\'' +
                ", sendDay=" + sendDay +
                '}';
    }
}

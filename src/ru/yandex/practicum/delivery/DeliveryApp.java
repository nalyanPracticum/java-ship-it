package ru.yandex.practicum.delivery;

import ru.yandex.practicum.delivery.Parcel.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final int maxWeightStandartParcelBox = 80;
    private static final int maxWeightFragileParcelBox = 40;
    private static final int maxWeightPerishableParcelBox = 50;
    private static final int currentDay = 15;

    private static final Scanner scanner = new Scanner(System.in);
    private static final List<Parcel> allParcels = new ArrayList<>();
    private static final List<FragileParcel> trackingList = new ArrayList<>();

    private static final ParcelBox<StandardParcel> standartParcelBox = new ParcelBox<>(maxWeightStandartParcelBox);
    private static final ParcelBox<FragileParcel> fragileParcelBox = new ParcelBox<>(maxWeightFragileParcelBox);
    private static final ParcelBox<PerishableParcel> perishableParcelBox = new ParcelBox<>(maxWeightPerishableParcelBox);

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            showMenu();

            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addParcel();
                        break;
                    case 2:
                        sendParcels();
                        break;
                    case 3:
                        calculateCosts();
                        break;
                    case 4:
                        printReportStatus();
                        break;
                    case 5:
                        showParcelBox();
                        break;
                    case 0:
                        running = false;
                        break;
                    default:
                        System.out.println("Неверный выбор.");
                }
            } catch (Exception e) {
                System.out.println("Неверный ввод.");
            }
        }
    }

    private static void showMenu() {
        System.out.println("\nВыберите действие:");
        System.out.println("1 — Добавить посылку");
        System.out.println("2 — Отправить все посылки");
        System.out.println("3 — Посчитать стоимость доставки");
        System.out.println("4 — Показать отчет о статусе отправления");
        System.out.println("5 — Показать содержимое коробки");
        System.out.println("0 — Завершить");
    }

    // реализуйте методы ниже

    private static void addParcel() {
        // Подсказка: спросите тип посылки и необходимые поля, создайте объект и добавьте в allParcels

        try {
            System.out.println("Выберите тип посылки:");
            System.out.println("1 - стандартная посылка");
            System.out.println("2 - хрупкая посылка");
            System.out.println("3 - скоропортящаяся посылка");

            int type_choice = Integer.parseInt(scanner.nextLine());
            int weight = 0;
            int sendDay = 0;

            boolean validInput = false;

            System.out.println("Введите краткое описание посылки: ");
            String description = scanner.nextLine();

            while (!validInput) {
                System.out.println("Введите вес посылки: ");
                weight = Integer.parseInt(scanner.nextLine());
                if (weight > 0) validInput = true;
                else {
                    System.out.println("Введите положительное число");
                }
            }

            System.out.println("Введите адрес доставки: ");
            String deliveryAdress = scanner.nextLine();

            validInput = false;
            while (!validInput) {
                System.out.println("Введите число месяца отправки: ");
                sendDay = Integer.parseInt(scanner.nextLine());
                if (sendDay > 0) validInput = true;
                else {
                    System.out.println("Введите положительное число");
                }
            }

            switch (type_choice) {
                case 1:
                    StandardParcel standartParcel = new StandardParcel(description, weight, deliveryAdress, sendDay);
                    if (!standartParcelBox.addParcel(standartParcel)) {
                        allParcels.add(standartParcel);
                        System.out.printf("Посылка <<%s>> добавлена!", description);
                    }
                    break;
                case 2:
                    FragileParcel fragileParcel = new FragileParcel(description, weight, deliveryAdress, sendDay);
                    if (!fragileParcelBox.addParcel(fragileParcel)) {
                        allParcels.add(fragileParcel);
                        trackingList.add(fragileParcel);
                        System.out.printf("Посылка <<%s>> добавлена!", description);
                    }
                    break;
                case 3:
                    System.out.println("Введите срок хранения посылки в днях: ");
                    int timeToLive = Integer.parseInt(scanner.nextLine());
                    PerishableParcel persihableParcel = new PerishableParcel(description, weight, deliveryAdress, sendDay, timeToLive);
                    if (!persihableParcel.isExpired(currentDay)) {
                        if (!perishableParcelBox.addParcel(persihableParcel)) {
                            allParcels.add(persihableParcel);
                            System.out.printf("Посылка <<%s>> добавлена!", description);
                        }
                    }
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
        } catch (Exception e) {
            System.out.println("Неверный ввод.");
        }
    }

    private static void sendParcels() {
        // Пройти по allParcels, вызвать packageItem() и deliver()
        for (Parcel parcel : allParcels) {
            String description = parcel.getDescription();
            String deliveryAdress = parcel.getDeliveryAddress();
            parcel.packageItem(description);
            parcel.deliver(description, deliveryAdress);
        }
    }

    private static void calculateCosts() {
        // Посчитать общую стоимость всех доставок и вывести на экран
        double deliveryCost = 0;
        for (Parcel parcel : allParcels) {
            deliveryCost += parcel.calculateDeliveryCost();
        }
        System.out.println("\nСтоимость доставки всех посылок составит: " + deliveryCost);
    }

    private static void printReportStatus() {
        if (!trackingList.isEmpty()) {
            System.out.println("Введите адрес местоположения посылки: ");
            String newLocation = scanner.nextLine();
            for (FragileParcel trackingParcel : trackingList) {
                trackingParcel.reportStatus(newLocation);
            }
        }
    }

    private static void showParcelBox() {
        System.out.println("Выберите коробку:");
        System.out.println("1 - коробка со стандартными посылками");
        System.out.println("2 - коробка с хрупкими посылками");
        System.out.println("3 - коробка со скоропортящимися посылками");

        int choice = Integer.parseInt(scanner.nextLine());

        try {
            switch (choice) {
                case 1:
                    standartParcelBox.getAllParcels();
                    break;
                case 2:
                    fragileParcelBox.getAllParcels();
                    break;
                case 3:
                    perishableParcelBox.getAllParcels();
                    break;
                default:
                    System.out.println("Неверный ввод.");
            }
        } catch (Exception e) {
            System.out.println("Неверный ввод.");
        }
    }
}


package ru.yandex.practicum.delivery;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeliveryApp {

    private static final Scanner scanner = new Scanner(System.in);
    private static List<Parcel> allParcels = new ArrayList<>();

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

            System.out.println("Введите краткое описание посылки: ");
            String description = scanner.nextLine();

            System.out.println("Введите вес посылки: ");
            int weight = Integer.parseInt(scanner.nextLine());

            System.out.println("Введите адрес доставки: ");
            String deliveryAdress = scanner.nextLine();

            System.out.println("Введите число месяца отправки: ");
            int sendDay = Integer.parseInt(scanner.nextLine());

            switch (type_choice) {
                case 1:
                    allParcels.add(new StandardParcel(description, weight, deliveryAdress, sendDay));
                    break;
                case 2:
                    allParcels.add(new FragileParcel(description, weight, deliveryAdress, sendDay));
                    break;
                case 3:
                    System.out.println("Введите срок хранения посылки в днях: ");
                    int timeToLive = Integer.parseInt(scanner.nextLine());
                    allParcels.add(new PerishableParcel(description, weight, deliveryAdress, sendDay, timeToLive));
                    break;
                default:
                    System.out.println("Неверный выбор.");
            }
            System.out.printf("Посылка <<%s>> добавлена!", description);
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

}


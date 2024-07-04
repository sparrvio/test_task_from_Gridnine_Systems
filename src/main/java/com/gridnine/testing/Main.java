package com.gridnine.testing;

import com.gridnine.testing.myFilters.ArrivalBeforeDepartureFilter;
import com.gridnine.testing.myFilters.DepartureBeforeCurrentTimeFilter;
import com.gridnine.testing.myFilters.FilterFlight;
import com.gridnine.testing.myFilters.TransferDurationExceedsTwoHoursFilter;
import com.gridnine.testing.testClasses.Flight;
import com.gridnine.testing.testClasses.FlightBuilder;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Flight> testFlights = FlightBuilder.createFlights();

        Scanner scanner = new Scanner(System.in);
        printMenu();
        String input = null;

        while (true) {
            input = scanner.nextLine();
            if (input.equals("1")) {
                FilterFlight departureBeforeCurrentTimeFilter = new DepartureBeforeCurrentTimeFilter();
                testFlights = departureBeforeCurrentTimeFilter.filter(testFlights);
                System.out.println("Фильтр перелетов где есть сегменты с вылетом до текущего момента времени:");
                printResultFlights(testFlights);
            } else if (input.equals("2")) {
                FilterFlight arrivalBeforeDepartureFilter = new ArrivalBeforeDepartureFilter();
                testFlights = arrivalBeforeDepartureFilter.filter(testFlights);
                System.out.println("Фильтр перелетов в которых есть сегменты с датой прилёта раньше даты вылета");
                printResultFlights(testFlights);
            } else if (input.equals("3")) {
                FilterFlight transferDurationExceedsTwoHoursFilter = new TransferDurationExceedsTwoHoursFilter();
                testFlights = transferDurationExceedsTwoHoursFilter.filter(testFlights);
                System.out.println("Фильтр по перелетам с общим временем простоем более двух часов");
                printResultFlights(testFlights);
            } else if (input.equals("4")) {
                printMenu();
                testFlights = FlightBuilder.createFlights();
            } else if (input.equals("5")) {
                System.out.println("Все полеты");
                List<Flight> info = FlightBuilder.createFlights();
                printResultFlights(info);
            } else if (input.equals("z")) {
                break;
            } else  {
                System.out.println("Неверный ввод");
                printMenu();
            }
        }
    }

    private static void printMenu() {
        System.out.println("Введите номер:" + '\n' +
                "1 - убрать полеты с вылетом до текущей даты" + '\n' +
                "2 - убрать полеты  с датой прилёта раньше даты вылета" + '\n' +
                "3 - убрать полеты со общим временм на земле более двух часов" + '\n' +
                "4 - очистить фильтры" + '\n' +
                "5 - посмотреть все полеты" + '\n' +
                "z - выход");
    }

    private static void printResultFlights(List<Flight> testFlights){
        testFlights.stream().forEach(System.out::println);
    }
}

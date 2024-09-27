package main.java.convertIntToDay;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Scanner;

public class DayOfDate {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Yıl : ");
        int year = sc.nextInt();
        sc.nextLine();
        System.out.println("Kaçıncı ay : ");
        int month = sc.nextInt();
        sc.nextLine();
        System.out.println("Ayın kaçıncı günü: ");
        int day = sc.nextInt();
        sc.nextLine();

        System.out.println(dayOfDate(year, month, day));

    }

    public static String dayOfDate(int year, int month, int day){
        LocalDate date = LocalDate.of(year, month, day);
        DayOfWeek dayOfDate = date.getDayOfWeek();
        Day dayOfDateEnum = convertDayOfWeekToDay(dayOfDate);
        return dayOfDateEnum.toString();
    }

    private static Day convertDayOfWeekToDay(DayOfWeek dayOfDate) {
        switch (dayOfDate) {
            case MONDAY -> {
                return Day.PAZARTESI;
            }
            case TUESDAY -> {
                return Day.SALI;
            }
            case WEDNESDAY -> {
                return Day.CARSAMBA;
            }
            case THURSDAY -> {
                return Day.PERSEMBE;
            }
            case FRIDAY -> {
                return Day.CUMA;
            }
            case SATURDAY -> {
                return Day.CUMARTESI;
            }
            case SUNDAY -> {
                return Day.PAZAR;
            }
            default -> throw new IllegalArgumentException("Bilinmeyen gün: " + String.valueOf(dayOfDate));
        }
    }
}



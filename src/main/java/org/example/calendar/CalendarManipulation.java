package org.example.calendar;

import java.util.Calendar;

public class CalendarManipulation {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        // Add 7 days to the current date
        calendar.add(Calendar.DAY_OF_MONTH, 7);
        System.out.println("Date after 7 days: " + calendar.getTime());
        // Subtract 2 months
        calendar.add(Calendar.MONTH, -2);
        System.out.println("Date after subtracting 2 months: " + calendar.getTime());
        // Add 1 year
        calendar.add(Calendar.YEAR, 1);
        System.out.println("Date after adding 1 year: " + calendar.getTime());
    }
}

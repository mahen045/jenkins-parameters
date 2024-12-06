package org.example.calendar;

import java.util.Calendar;

public class BasicCalendar {
    public static void main(String[] args) {
        // Create a Calendar instance
        Calendar calendar = Calendar.getInstance();

        // Get the current date and time
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH); // Note: Month is 0-based
        int day = calendar.get(Calendar.DAY_OF_MONTH);
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int second = calendar.get(Calendar.SECOND);

        // Print the current date and time
        System.out.println("Current Date and Time:");
        System.out.printf("%d-%02d-%02d %02d:%02d:%02d\n", year, month + 1, day, hour, minute, second);
    }
}

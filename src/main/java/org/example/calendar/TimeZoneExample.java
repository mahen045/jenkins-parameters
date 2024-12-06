package org.example.calendar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;

public class TimeZoneExample {
    public static void main(String[] args) {
        Calendar ny_time = Calendar.getInstance();
        ny_time.setTimeZone(TimeZone.getTimeZone("America/New_York"));
        System.out.println("Current Time in New York: " + ny_time.get(Calendar.HOUR_OF_DAY) + ":"
                + ny_time.get(Calendar.MINUTE)+":"+ny_time.get(Calendar.SECOND));
    }


}

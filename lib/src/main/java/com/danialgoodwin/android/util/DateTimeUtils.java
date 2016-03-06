/**
 * Created by Danial Goodwin on 2016-03-03.
 */
package com.danialgoodwin.android.util;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;

/** Helper methods related to dates and times. */
public class DateTimeUtils {

    // Note: This is not thread-safe. Depending on usage, it could be better for using ThreadLocal or inline.
//     private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); // Could be "yyyyMMdd_HHmmss".

    /* Suppress default constructor for non-instantiability. */
    private DateTimeUtils() { throw new AssertionError(); }

    /** Return the current date formatted as "yyyy-MM-dd". */
    public static String getYearMonthDay() {
        GregorianCalendar calendar = new GregorianCalendar();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd")
//        sdf.format();
        // Possibly faster than above, need to test.
        return String.format(Locale.US, "%d-%d-%d", year, month, day);
    }

    /** Return the current time for the device locale. */
//    public static long getTimeMillisInLocale() {
//        GregorianCalendar calendar = new GregorianCalendar();
//        return calendar.getTimeInMillis();
//    }

}

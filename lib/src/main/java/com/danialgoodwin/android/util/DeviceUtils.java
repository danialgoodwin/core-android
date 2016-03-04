/**
 * Created by Danial Goodwin on 2014-06-01.
 */
package com.danialgoodwin.android.util;

import android.content.Context;
import android.content.res.Configuration;
import android.support.annotation.NonNull;

// More info: http://developer.android.com/guide/practices/screens_support.html
/** Helper methods related to device. */
public class DeviceUtils {

    /* Suppress default constructor for non-instantiability. */
    private DeviceUtils() { throw new AssertionError(); }

    /** Return true if device is at least 480x640 dp, otherwise false. */
    public static boolean isTablet(@NonNull Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;
    }

    /** Return true if device is at least 720x960 dp, otherwise false. */
    public static boolean isTabletLarge(@NonNull Context context) {
        return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_XLARGE;
    }

}

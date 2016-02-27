/**
 * Created by Danial Goodwin on 2014-06-01.
 */
package com.danialgoodwin.android.util;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.view.Display;

/** Helper methods related to device orientation. */
public class OrientationUtils {

    /* Suppress default constructor for non-instantiability. */
    private OrientationUtils() { throw new AssertionError(); }

    /** Return true if device in in landscape mode, otherwise false. */
    public static boolean isLandscape(@NonNull Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }

    /** Return true if device in in portrait mode, otherwise false. */
    public static boolean isPortrait(@NonNull Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT;
    }

    /** Return the screen orientation, which can be any of the following:
     *    Configuration.ORIENTATION_LANDSCAPE
     *    Configuration.ORIENTATION_PORTRAIT
     *    Configuration.ORIENTATION_SQUARE
     *    Configuration.ORIENTATION_UNDEFINED
     */
    public static int getScreenOrientation(@NonNull Activity activity) {
        Display getOrient = activity.getWindowManager().getDefaultDisplay();
        int orientation = Configuration.ORIENTATION_UNDEFINED;
        if (getOrient.getWidth() == getOrient.getHeight()) {
            orientation = Configuration.ORIENTATION_SQUARE;
        } else {
            if (getOrient.getWidth() < getOrient.getHeight()) {
                orientation = Configuration.ORIENTATION_PORTRAIT;
            } else {
                orientation = Configuration.ORIENTATION_LANDSCAPE;
            }
        }
        return orientation;
    }

    /** Lock the device window in landscape mode. */
    public static void lockLandscape(@NonNull Activity activity) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    /** Lock the device window in portrait mode. */
    public static void lockPortrait(@NonNull Activity activity) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }

    /** Allow user to freely use portrait or landscape mode. */
    public static void unlockOrientation(@NonNull Activity activity) {
        activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
    }

}

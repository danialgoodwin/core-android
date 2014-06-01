package net.simplyadvanced.utils;

import android.content.Context;
import android.content.res.Configuration;

/** Static methods related to device orientation. */
public class OrientationUtils {
    private OrientationUtils() {}

    /** Returns true if device in in landscape mode, otherwise false. */
    public static boolean isLandscape(Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_LANDSCAPE;
    }
    
    /** Returns true if device in in portrait mode, otherwise false. */
    public static boolean isPortrait(Context context) {
        return context.getResources().getConfiguration().orientation
                == Configuration.ORIENTATION_PORTRAIT;
    }

}

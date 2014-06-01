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
    
    /** Returns the screen orientation, which can be any of the following:
      *    Configuration.ORIENTATION_LANDSCAPE
      *    Configuration.ORIENTATION_PORTRAIT
      *    Configuration.ORIENTATION_SQUARE
      *    Configuration.ORIENTATION_UNDEFINED
      */
    public static int getScreenOrientation() {
        Display getOrient = getWindowManager().getDefaultDisplay();
        int orientation = Configuration.ORIENTATION_UNDEFINED;
        if(getOrient.getWidth() == getOrient.getHeight()) {
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

}

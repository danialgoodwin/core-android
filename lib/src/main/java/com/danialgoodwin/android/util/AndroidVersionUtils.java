/**
 * Created by Danial Goodwin on 2015-08-07.
 */
package com.danialgoodwin.android.util;

import android.os.Build;

/** Helper methods related to Android API versions. */
public class AndroidVersionUtils {

    /** Is Jelly Bean or above. */
    public static final boolean IS_API_16_OR_ABOVE = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN;

    /** Is Jelly Bean or above. */
    public static final boolean IS_API_17_OR_ABOVE = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1;

    /** Is Lollipop or above. */
    public static final boolean IS_API_21_OR_ABOVE = Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP;

    /** Is Marshmallow or above. */
    public static final boolean IS_API_23_OR_ABOVE = Build.VERSION.SDK_INT >= 23;

    public static final boolean IS_CELL_INFO_AVAILABLE = IS_API_17_OR_ABOVE;
    public static final boolean IS_CELL_INFO_WCDMA_AVAILABLE = Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR2;

    /* Suppress default constructor for non-instantiability. */
    private AndroidVersionUtils() { throw new AssertionError(); }

}

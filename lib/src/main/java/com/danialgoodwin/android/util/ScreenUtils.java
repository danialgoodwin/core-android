/**
 * Created by Danial Goodwin on 2016-03-04.
 */
package com.danialgoodwin.android.util;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.Window;

/** Helper methods related to the screen. */
public class ScreenUtils {

    /* Suppress default constructor for non-instantiability. */
    private ScreenUtils() { throw new AssertionError(); }

    // More info: http://developer.android.com/reference/android/view/View.html#attr_android%3akeepScreenOn
    /** Force screen to stay on for an Activity. Alternatives to this method would be adding the
     * flag at the View level, or setting it in XML `android:keepScreenOn="true".
     * @param activity the page to keep the screen on
     * @param isKeepScreenOn set true to force screen to stay on, set false to allow screen to turn off
     */
    public static void keepScreenOn(@NonNull Activity activity, boolean isKeepScreenOn) {
        Window window = activity.getWindow();
        if (window == null) { return; }
        if (isKeepScreenOn) {
            // More info: http://developer.android.com/reference/android/view/WindowManager.LayoutParams.html#FLAG_KEEP_SCREEN_ON
            window.addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        } else {
            // More info: http://developer.android.com/reference/android/view/Window.html#clearFlags%28int%29
            window.clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        }
    }

}

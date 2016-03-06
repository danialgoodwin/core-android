/**
 * Created by Danial Goodwin on 2016-02-26.
 */
package com.danialgoodwin.android.util;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;

/** Helper methods related to Activity. */
public class ActivityUtils {

    /* Suppress default constructor for non-instantiability. */
    private ActivityUtils() { throw new AssertionError(); }

    /** Show another Activity. */
    public static void show(@NonNull Context fromContext, @NonNull Class<? extends Activity> toActivity) {
        Intent intent = new Intent(fromContext, toActivity);
        if (!(fromContext instanceof Activity)) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        }
        fromContext.startActivity(intent);
    }

}

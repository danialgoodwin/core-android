package net.simplyadvanced.apis;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;

/** Helper methods for Google Play services-related operations. */
public class GooglePlayServicesApi {
    private GooglePlayServicesApi() {}
    
    // Source: https://code.google.com/p/iosched/source/browse/android/src/main/java/com/google/android/apps/iosched/util/PlayServicesUtils.java
    /** Returns true if Google Play Services are available, otherwise
      * returns false and closes Activity on prompt cancel. */
    public static boolean isAvailableElsePrompt(final Activity activity) {
        final int googlePlayServicesCheck = GooglePlayServicesUtil.isGooglePlayServicesAvailable(activity);
        switch (googlePlayServicesCheck) {
            case ConnectionResult.SUCCESS:
                return true;
            case ConnectionResult.SERVICE_DISABLED:
            case ConnectionResult.SERVICE_INVALID:
            case ConnectionResult.SERVICE_MISSING:
            case ConnectionResult.SERVICE_VERSION_UPDATE_REQUIRED:
                Dialog dialog = GooglePlayServicesUtil.getErrorDialog(googlePlayServicesCheck, activity, 0);
                dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                        activity.finish();
                    }
                });
                dialog.show();
        }
        return false;
    }
    
}

package net.simplyadvanced.widget;

import android.widgets.Toast;

/** Allows for easy customization of Toasts later. */
public class CustomToast {
    private CustomToast() {}
    
    /** Shows a basic Toast message to user. */
    public static void show(Activity activity, CharSequence message) {
        Toast.makeText(activity, message, Toast.LENGTH_LONG).show();
        // Toast.makeText(activity, message, Toast.LENGTH_SHORT).show();
    }
    
}

/**
 * Created by Danial Goodwin on 2016-01-24.
 */
package com.danialgoodwin.android;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.DrawableRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.NotificationCompat;
import android.widget.Toast;

/** Helper methods to show simple messages to users. */
public class SimpleMessage {

    private static final int ID_NOTIFICATION_MAIN = 0;

    private static Toast mOneToast;
    private static Handler mMainThreadHandler;

    /* Suppress default constructor for non-instantiability. */
    private SimpleMessage() { throw new AssertionError(); }

    /** Show a quick passive message to the user. */
    public static void showToast(@NonNull Context context, @NonNull CharSequence message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /** Show a quick passive message to the user. This will first stop previous messages shown
     * from this same method. */
    public static void showOneToast(@NonNull Context context, @NonNull CharSequence message) {
        if (mOneToast != null) { mOneToast.cancel(); }
        mOneToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
        mOneToast.show();
    }

    /** Show a message in the notification bar */
    public static void showNotification(@NonNull Context context, @NonNull CharSequence title,
            @NonNull CharSequence message, @DrawableRes int icon, @Nullable PendingIntent intent) {
        Notification notification = new NotificationCompat.Builder(context)
                .setContentTitle(title)
                .setContentText(message)
                .setSmallIcon(icon)
                .setStyle(new NotificationCompat.BigTextStyle().bigText(message))
                .setContentIntent(intent)
                .build();
        NotificationManager manager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(ID_NOTIFICATION_MAIN, notification);
    }

    /** Show an interrupting prompt message. */
    public static void showPrompt(@NonNull Context context, @NonNull CharSequence title, @NonNull CharSequence message) {
        new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .show();
    }

    /** Show a quick passive message only in debug builds. */
    public static void debugShowToast(@NonNull final Context context, @NonNull final CharSequence message) {
        if (!BuildConfig.DEBUG) { return; }
        if (Looper.myLooper() != null) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        } else {
            if (mMainThreadHandler == null) { mMainThreadHandler = new Handler(Looper.getMainLooper()); }
            mMainThreadHandler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

}

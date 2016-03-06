/**
 * Created by Danial Goodwin on 2014-06-03.
 */
package com.danialgoodwin.android.util;

import android.content.Context;
import android.media.AudioManager;
import android.support.annotation.NonNull;

/** Helper methods related to audio. */
public class AudioUtils {

    /* Suppress default constructor for non-instantiability. */
    private AudioUtils() { throw new AssertionError(); }

    /** Return true if device ringer is silent or vibrate, otherwise false. */
    public static boolean isRingerSilent(@NonNull Context context) {
        AudioManager am = getAudioManager(context);
        int ringerMode = am.getRingerMode();
        if ((ringerMode == AudioManager.RINGER_MODE_SILENT)
                || (ringerMode == AudioManager.RINGER_MODE_VIBRATE)) {
            return true;
        }
        return false;
    }

    /** Return the volume for the ringer. */
    public static int getRingerVolume(@NonNull Context context) {
        return getAudioManager(context).getStreamVolume(AudioManager.STREAM_RING);
    }

    /** Return the volume for notifications. */
    public static int getNotificationVolume(@NonNull Context context) {
        return getAudioManager(context).getStreamVolume(AudioManager.STREAM_NOTIFICATION);
    }

    /** Return the volume for music. */
    public static int getMusicVolume(@NonNull Context context) {
        return getAudioManager(context).getStreamVolume(AudioManager.STREAM_MUSIC);
    }

    private static AudioManager getAudioManager(@NonNull Context context) {
        return (AudioManager) context.getApplicationContext()
                .getSystemService(Context.AUDIO_SERVICE);
    }

}

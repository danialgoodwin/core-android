package net.simplyadvanced.utils;

import android.content.Context;
import android.media.AudioManager;

/** Static methods related to device audio. */
public class AudioUtils {
    private AudioUtils() {}
    
    /** Returns true if device ringer is silent or vibrate, otherwise false. */
    public static boolean isRingerSilent(Context context) {
        AudioManager am = getAudioManager(context);
        int ringerMode = am.getRingerMode();
        if ((ringerMode == AudioManager.RINGER_MODE_SILENT)
                || (ringerMode == AudioManager.RINGER_MODE_VIBRATE)) {
            return true;
        }
        return false;
    }
    
    /** Returns the volume for the ringer. */
    public static int getRingerVolume(Context context) {
        AudioManager am = getAudioManager(context);
        return am.getStreamVolume(AudioManager.STREAM_RING);
    }
    
    /** Returns the volume for notifications. */
    public static int getNotificationVolume(Context context) {
        AudioManager am = getAudioManager(context);
        return am.getStreamVolume(AudioManager.STREAM_NOTIFICATION);
    }
    
    /** Returns the volume for music. */
    public static int getMusicVolume(Context context) {
        AudioManager am = getAudioManager(context);
        return am.getStreamVolume(AudioManager.STREAM_MUSIC);
    }
    
    private static AudioManager getAudioManager(Context context) {
        return (AudioManager) context.getApplicationContext()
                .getSystemService(Context.AUDIO_SERVICE);
    }
    
}

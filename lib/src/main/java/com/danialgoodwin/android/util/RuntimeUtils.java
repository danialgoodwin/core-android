/**
 * Created by Danial Goodwin on 2016-03-05.
 */
package com.danialgoodwin.android.util;

import android.os.SystemPropertiesReflect;

/** Helper methods related to the Android runtime (Dalvik and ART). */
public class RuntimeUtils {

    private static final String SELECT_RUNTIME_PROPERTY = "persist.sys.dalvik.vm.lib";
    private static final String LIB_DALVIK = "libdvm.so";
    private static final String LIB_ART = "libart.so";
    private static final String LIB_ART_D = "libartd.so";

    private static final String TAG_DALVIK = "Dalvik";
    private static final String TAG_ART = "ART";
    private static final String TAG_ART_DEBUG_BUILD = "ART debug build";

    /* Suppress default constructor for non-instantiability. */
    private RuntimeUtils() { throw new AssertionError(); }


    /** Return true if device has the Dalvik runtime, otherwise false. */
    public static boolean isRuntimeDalvik() {
        return getCurrentRuntime().equalsIgnoreCase(LIB_DALVIK);
    }

    /** Return true if device has the ART or ART debug build runtime, otherwise false. */
    public static boolean isRuntimeArt() {
        String runtime = getCurrentRuntime();
        return runtime.equalsIgnoreCase(LIB_ART) || runtime.equalsIgnoreCase(LIB_ART_D);
    }

    /** Return the current runtime, otherwise null.
     * @return current runtime
     */
    public static String getCurrentRuntime() {
        return SystemPropertiesReflect.get(SELECT_RUNTIME_PROPERTY);
    }

    /** Return the name of the current runtime, otherwise null.
     * @return current runtime
     */
    public static String getCurrentRuntimeName() {
        String runtime = getCurrentRuntime();
        switch (runtime) {
            case LIB_ART: return TAG_ART;
            case LIB_ART_D: return TAG_ART_DEBUG_BUILD;
            case LIB_DALVIK: return TAG_DALVIK;
            default: return runtime;
        }
    }

}

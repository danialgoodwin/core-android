/**
 * Created by Danial Goodwin on 2016-01-27.
 */
package com.danialgoodwin.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Simple utility to save and get persistent data.
 *
 * Usage:
 * <code>
 *     SimplePrefs storage = SimplePrefs.getInstance(mContext, "my-feature-prefs");
 *     storage.set("key", "value");
 *     String value = storage.get("key", "defaultValue"); // Returns "value"
 * </code>
 */
public class SimplePrefs {

    private SharedPreferences mSharedPreferences;

    /** Create default storage for app. */
    private SimplePrefs(@NonNull Context context) {
        mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
    }

    /** Create isolated storage based on the provided name. */
    private SimplePrefs(@NonNull Context context, @Nullable String storageName) {
        mSharedPreferences = context.getApplicationContext()
                .getSharedPreferences(storageName, Context.MODE_PRIVATE);
    }

    /** Return an instance of this class. */
    public static SimplePrefs getInstance(@NonNull Context context) {
        return new SimplePrefs(context);
    }

    /** Return an instance of this class. The provided name is used to create isolated storage. */
    public static SimplePrefs getInstance(@NonNull Context context, @NonNull String storageName) {
        return new SimplePrefs(context, storageName);
    }

    /** Save data for later. */
    public void set(@NonNull String key, boolean value) {
        mSharedPreferences.edit().putBoolean(key, value).apply();
    }

    /** Save data for later. */
    public void set(@NonNull String key, int value) {
        mSharedPreferences.edit().putInt(key, value).apply();
    }

    /** Save data for later. */
    public void set(@NonNull String key, long value) {
        mSharedPreferences.edit().putLong(key, value).apply();
    }

    /** Save data for later. */
    public void set(@NonNull String key, @Nullable String value) {
        mSharedPreferences.edit().putString(key, value).apply();
    }

    /** Retrieve data from storage, using the default value if key is not found. */
    public boolean get(@NonNull String key, boolean defaultValue) {
        return mSharedPreferences.getBoolean(key, defaultValue);
    }

    /** Retrieve data from storage, using the default value if key is not found. */
    public int get(@NonNull String key, int defaultValue) {
        return mSharedPreferences.getInt(key, defaultValue);
    }

    /** Retrieve data from storage, using the default value if key is not found. */
    public long get(@NonNull String key, long defaultValue) {
        return mSharedPreferences.getLong(key, defaultValue);
    }

    /** Retrieve data from storage, using the default value if key is not found. */
    @Nullable
    public String get(@NonNull String key, @Nullable String defaultValue) {
        return mSharedPreferences.getString(key, defaultValue);
    }

}

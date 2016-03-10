/**
 * Created by Danial Goodwin on 2016-01-27.
 */
package com.danialgoodwin.android;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/** A shell with buffered reader and data output already set up. */
public class SimpleShell {

    @Nullable public Process process;
    @Nullable public DataOutputStream stdin;
    @Nullable public BufferedReader stdout;

    private SimpleShell(@NonNull String shell) {
        try {
            process = Runtime.getRuntime().exec(shell);
            stdin = new DataOutputStream(process.getOutputStream());
            stdout = new BufferedReader(new InputStreamReader(process.getInputStream()));
        } catch (IOException ignored) {
            Log.d("App: BSS", "SU not available");
        }
    }

    /** Return a new instance of su shell. */
    public static SimpleShell newSu() {
        return new SimpleShell("su");
    }

    /** Return a new instance of sh shell. */
    public static SimpleShell newSh() {
        return new SimpleShell("sh");
    }

    /** Return true if this shell is available, otherwise false. */
    public boolean isAvailable() {
        return process != null;
    }

}

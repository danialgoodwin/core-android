package com.danialgoodwin.android.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;

import java.util.List;

/** Helper methods related to packages. */
public class PackageUtils {

    private static PackageUtils mPackageUtils;
    private Context mAppContext;
    private PackageManager mPackageManager;

    private PackageUtils(@NonNull Context appContext) {
        mAppContext = appContext;
        mPackageManager = appContext.getPackageManager();
    }

    /**
     *
     * @param context the application context will be used
     * @return an instance of this class
     */
    @NonNull
    public static PackageUtils getInstance(@NonNull Context context) {
        if (mPackageUtils == null) {
            mPackageUtils = new PackageUtils(context.getApplicationContext());
        }
        return mPackageUtils;
    }

    @NonNull
    public List<ApplicationInfo> getAllPackages() {
        return mPackageManager.getInstalledApplications(0);
    }

    /** Return true if the internet permission is declared in manifest, otherwise false. */
    public boolean isInternetPermissionRequested(@NonNull String packageName) {
        try {
            PackageInfo app = mPackageManager.getPackageInfo(packageName, PackageManager.GET_PERMISSIONS);
            if (app.requestedPermissions != null) {
                for (String permission : app.requestedPermissions) {
                    if (permission.equals(android.Manifest.permission.INTERNET)) {
                        return true;
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException ignore) {}
        return false;
    }

    /** Return true if the app is stopped, otherwise. */
    public boolean isAppStopped(@NonNull String packageName) {
        try {
            PackageInfo packageInfo = mPackageManager.getPackageInfo(packageName, 0);
            //noinspection UnnecessaryLocalVariable
            boolean isStopped = (packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_STOPPED) != 0;
            return isStopped;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }

    /**
     * Enable or disable an app component.
     * @param componentClass the app component to enable or disable
     * @param isEnable set true to enable component, set false to disable component
     */
    public void enableComponent(@NonNull Class<?> componentClass, boolean isEnable) {
        ComponentName component = new ComponentName(mAppContext, componentClass);
        mPackageManager.setComponentEnabledSetting(component,
                isEnable ? PackageManager.COMPONENT_ENABLED_STATE_ENABLED :
                        PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }

    @NonNull
    private PackageManager getPackageManager() {
        return mPackageManager;
    }

    //    public int[] getPackageUid(String packageName) {
//        try {
//            mPackageManager.getPackageUid(packageName); // API is hidden
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    // Android doesn't provide native support for IntentFilters yet
//    public boolean isContainPackageAddedReceiver(String packageName) {
//        if (packageName == null || packageName.isEmpty()) { return false; }
//        try {
//            PackageInfo packageInfo = mPackageManager.getPackageInfo(packageName, PackageManager.GET_RECEIVERS | PackageManager.GET_INTENT_FILTERS);
//            ActivityInfo[] receivers = packageInfo.receivers;
//            for (ActivityInfo receiver : receivers) {
//                receiver.
//            }
//        } catch (PackageManager.NameNotFoundException e) {
//            e.printStackTrace();
//        }
//    }

}

package net.simplyadvanced.helper;

import net.simplyadvanced.ltediscovery.settings.UserPrefs;
import android.app.Activity;
import android.view.Window;

// Another method to keep screen on is to set a flag in the layout xml for `android:keepScreenOn="true"`.
// More info: http://developer.android.com/reference/android/view/View.html#attr_android%3akeepScreenOn
/** Controls keeping the device screen on or not. */
public class ScreenManager {
	private ScreenManager() {}
	
	
	
	/** Forces screen to stay on when on a certain Activity. This handles
	 * the user preferences.
	 * 
	 * @param activity The page to keep on.
	 * @param keepScreenOn If true, then forces screen to stay on. If false,
	 *  then allows screen to turn off.
	 */
	public static void keepScreenOn(Activity activity, boolean keepScreenOn) {
		if (activity == null) { return; }

		Window window = activity.getWindow();
		if (window == null) { return; }
		
		if (keepScreenOn && UserPrefs.getInstance().isKeepScreenOn()) {
			// More info: http://developer.android.com/reference/android/view/WindowManager.LayoutParams.html#FLAG_KEEP_SCREEN_ON
			window.addFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		} else {
			// More info: http://developer.android.com/reference/android/view/Window.html#clearFlags%28int%29
			window.clearFlags(android.view.WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		}
	}

	
	
	// Old and deprecated code
	
//	private static WakeLock wakeLock;
//	
//	private static final String WAKE_LOCK_TAG = "whateverWaitLock"; // Arbitrary string.
//
//	/** Keeps the device screen on when called, if user has option enabled in
//	 * Settings. Be sure to call release when done. */
//	@SuppressWarnings("deprecation")
//	public void activateWaitLock() {
//		Context context = BaseApp.getContext();
//    	boolean prefKeepScreenOn = HelperCommon.getInstance(context).getUserPreference(HelperCommon.TAG_SETTINGS_KEEP_SCREEN_ON, false);
//		if (prefKeepScreenOn) {
////		    getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON); // TODOv2: // Don't need permission using this.
//			PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
//			wakeLock = pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, WAKE_LOCK_TAG); // OR: PARTIAL_WAKE_LOCK, SCREEN_DIM_WAKE_LOCK, SCREEN_BRIGHT_WAKE_LOCK, FULL_WAKE_LOCK
//			if (!wakeLock.isHeld()) {
//				wakeLock.acquire();
//			}
//		} else {
//			// Ensure that screen can turn off.
//			releaseWaitLock();
//		}
//	}
//	
//	/** Allows device screen to turn off regularly. */
//	public void releaseWaitLock() {
//		if (wakeLock == null) { return; }
//		
//		if (wakeLock.isHeld()) {
//			wakeLock.release();
//		}
//		wakeLock = null;
//	}
	
}

/**
 * Created by Danial Goodwin on 2016-02-21.
 */
package com.danialgoodwin.android.view.style;

import android.support.annotation.Nullable;
import android.text.TextPaint;
import android.text.style.CharacterStyle;
import android.text.style.UpdateAppearance;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

// More info: http://stackoverflow.com/a/13287419/887894
// More info: http://stackoverflow.com/questions/30716673/changing-the-underline-color-of-textview
// More info: http://stackoverflow.com/questions/19976977/how-to-get-underlinespan-with-another-color-in-android
/** An UnderlineSpan with a definable underline color.
 *
 * If you use many ColorUnderlineSpan all the time, then it may be better to set
 * `mSetUnderlineTextMethod` to static and load it just once.
 *
 * This currently uses reflection and the method may not be available on all devices. In that
 * case there is a fall-back to use the default underline color.
 *
 * Usage:
 * <code>
 *     ColorUnderlineSpan span = ColorUnderlineSpan.new(int color);
 * </code>
 */
public class ColorUnderlineSpan extends CharacterStyle implements UpdateAppearance {

    private final int mUnderlineColor;
    private final float mUnderlineThickness;
    @Nullable private Method mSetUnderlineTextMethod = null;

    public ColorUnderlineSpan(int underlineColor) {
        this(underlineColor, 1.0f);
    }

    public ColorUnderlineSpan(int underlineColor, float underlineThickness) {
        mUnderlineColor = underlineColor;
        mUnderlineThickness = underlineThickness;
        try {
            mSetUnderlineTextMethod = TextPaint.class.getMethod("setUnderlineText",
                    Integer.TYPE, Float.TYPE);
        } catch (NoSuchMethodException ignore) {}
    }

    @Override
    public void updateDrawState(final TextPaint tp) {
        if (mSetUnderlineTextMethod != null) {
            //noinspection TryWithIdenticalCatches
            try {
                mSetUnderlineTextMethod.invoke(tp, mUnderlineColor, mUnderlineThickness);
                return;
            } catch (IllegalAccessException ignore) {
            } catch (InvocationTargetException ignore) {}
        }
        // Fall back
        tp.setUnderlineText(true);
    }

}

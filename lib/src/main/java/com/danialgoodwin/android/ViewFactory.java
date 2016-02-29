/**
 * Created by Danial Goodwin on 2016-02-28.
 */
package com.danialgoodwin.android;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;

/** Quickly build views, programmatically. Some "advanced" layouts may be easier through XML.
 *
 * Usage:
 * <code>
 *     ViewFactory vf = new ViewFactory(context);
 *     View title = vf.text("Title");
 *     View message = vf.text("A message description");
 *     View button = vf.button("Okay", new View.OnClickListener() {
 *         @Override
 *         public onClick(View v) {
 *             // Do something
 *         }
 *     });
 *     View rootView = vf.scroll(vf.col(title, message, button));
 * </code>
 *
 */
public class ViewFactory {

    private Context mContext;

    public ViewFactory(@NonNull Context context) {
        mContext = context;
    }

    /** Return a new vertical ScrollView with the single child view from input. */
    @NonNull
    public ScrollView scroll(@NonNull View view) {
        ScrollView scrollView = new ScrollView(mContext);
        scrollView.addView(view);
        return scrollView;
    }

    /** Return a new vertical LinearLayout. */
    @NonNull
    public LinearLayout col() {
        LinearLayout root = new LinearLayout(mContext);
        root.setOrientation(LinearLayout.VERTICAL);
        return root;
    }

    /** Return a new vertical LinearLayout with non-null views added in order. */
    @NonNull
    public LinearLayout col(@Nullable View... views) {
        LinearLayout root = new LinearLayout(mContext);
        root.setOrientation(LinearLayout.VERTICAL);
        if (views != null) {
            for (View view : views) {
                if (view != null) {
                    root.addView(view);
                }
            }
        }
        return root;
    }

    /** Return a new TextView with the text set. */
    @NonNull
    public TextView text(@Nullable String title) {
        TextView textView = new TextView(mContext);
        textView.setText(title);
        return textView;
    }

    /** Return a new Button with the text and onClickListener set. */
    @NonNull
    public Button button(String title, View.OnClickListener listener) {
        Button button = new Button(mContext);
        button.setText(title);
        button.setOnClickListener(listener);
        return button;
    }

    /** Return a new "determinate" ProgressBar. */
    @NonNull
    public ProgressBar progressBar() {
        ProgressBar progressBar = new ProgressBar(mContext, null, android.R.attr.progressBarStyleHorizontal);
        progressBar.setIndeterminate(false);
        return progressBar;
    }

    /** Return a new indeterminate ProgressBar with the small spinner style. */
    @NonNull
    public ProgressBar progressSpinnerSmall() {
        ProgressBar progressBar = new ProgressBar(mContext, null, android.R.attr.progressBarStyleSmall);
        progressBar.setIndeterminate(true);
        return progressBar;
    }

}

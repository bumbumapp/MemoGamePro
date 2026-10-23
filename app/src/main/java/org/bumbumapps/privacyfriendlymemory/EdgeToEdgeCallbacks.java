package org.bumbumapps.privacyfriendlymemory;

import android.app.Activity;
import android.app.Application;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import org.bumbumapps.privacyfriendlymemory.ui.R;
import androidx.annotation.Nullable;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

/**
 * Android 15+ draws apps edge-to-edge. Pads every activity's content view by the system bar,
 * display cutout and keyboard insets so nothing is drawn under the status / navigation bars.
 * On Android 15+ the status bar colour from the theme is ignored, so a scrim in the theme's
 * status bar colour (colorPrimaryDark) is drawn behind the status bar, and the icon appearance
 * (light / dark) is chosen from that colour so the icons stay readable in every theme.
 * Register once from Application.onCreate().
 */
public final class EdgeToEdgeCallbacks implements Application.ActivityLifecycleCallbacks {

    public static void register(Application app) {
        app.registerActivityLifecycleCallbacks(new EdgeToEdgeCallbacks());
    }

    static void apply(View content) {
        apply(content, null);
    }

    static void apply(View content, @Nullable View statusBarScrim) {
        if (content == null || content.getTag(R.id.edge_to_edge_applied) != null) {
            return;
        }
        content.setTag(R.id.edge_to_edge_applied, Boolean.TRUE);
        ViewCompat.setOnApplyWindowInsetsListener(content, (v, insets) -> {
            Insets bars = insets.getInsets(WindowInsetsCompat.Type.systemBars()
                    | WindowInsetsCompat.Type.displayCutout());
            Insets ime = insets.getInsets(WindowInsetsCompat.Type.ime());
            v.setPadding(bars.left, bars.top, bars.right, Math.max(bars.bottom, ime.bottom));
            if (statusBarScrim != null) {
                ViewGroup.LayoutParams lp = statusBarScrim.getLayoutParams();
                if (lp.height != bars.top) {
                    lp.height = bars.top;
                    statusBarScrim.setLayoutParams(lp);
                }
            }
            return WindowInsetsCompat.CONSUMED;
        });
        ViewCompat.requestApplyInsets(content);
    }

    static void applyStatusBar(Activity activity, View content) {
        if (content == null || content.getTag(R.id.edge_to_edge_applied) != null) {
            return;
        }
        int color = statusBarColor(activity);
        View scrim = null;
        View decor = activity.getWindow().getDecorView();
        if (Build.VERSION.SDK_INT >= 35 && decor instanceof FrameLayout) {
            // Window#setStatusBarColor is a no-op on Android 15+: draw the colour ourselves.
            scrim = new View(activity);
            scrim.setBackgroundColor(color);
            scrim.setImportantForAccessibility(View.IMPORTANT_FOR_ACCESSIBILITY_NO);
            ((FrameLayout) decor).addView(scrim, new FrameLayout.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 0, Gravity.TOP));
        }
        new WindowInsetsControllerCompat(activity.getWindow(), decor)
                .setAppearanceLightStatusBars(isLightColor(color));
        apply(content, scrim);
    }

    /** The colour drawn behind the status bar: the window's status bar colour, else colorPrimaryDark. */
    private static int statusBarColor(Activity activity) {
        int color = activity.getWindow().getStatusBarColor();
        if (Color.alpha(color) == 0xFF) {
            return color;
        }
        TypedArray a = activity.obtainStyledAttributes(
                new int[]{androidx.appcompat.R.attr.colorPrimaryDark});
        try {
            return a.getColor(0, Color.BLACK);
        } finally {
            a.recycle();
        }
    }

    /** True if [argb] is light enough that status bar icons on top of it must be dark. */
    static boolean isLightColor(int argb) {
        double r = channel((argb >> 16) & 0xFF);
        double g = channel((argb >> 8) & 0xFF);
        double b = channel(argb & 0xFF);
        double luminance = 0.2126 * r + 0.7152 * g + 0.0722 * b;
        return luminance > 0.5;
    }

    private static double channel(int c) {
        double v = c / 255.0;
        return v <= 0.03928 ? v / 12.92 : Math.pow((v + 0.055) / 1.055, 2.4);
    }

    @Override
    public void onActivityStarted(@NonNull Activity activity) {
        // Leave third-party (ads / consent) activities alone; they handle insets themselves.
        if (activity.getClass().getName().startsWith("com.google.")) {
            return;
        }
        applyStatusBar(activity, activity.findViewById(android.R.id.content));
    }

    @Override
    public void onActivityCreated(@NonNull Activity activity, @Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onActivityResumed(@NonNull Activity activity) {
    }

    @Override
    public void onActivityPaused(@NonNull Activity activity) {
    }

    @Override
    public void onActivityStopped(@NonNull Activity activity) {
    }

    @Override
    public void onActivitySaveInstanceState(@NonNull Activity activity, @NonNull Bundle outState) {
    }

    @Override
    public void onActivityDestroyed(@NonNull Activity activity) {
    }
}

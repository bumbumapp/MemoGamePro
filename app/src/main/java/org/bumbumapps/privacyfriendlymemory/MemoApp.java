package org.bumbumapps.privacyfriendlymemory;

import android.app.Application;

public class MemoApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        EdgeToEdgeCallbacks.register(this);
    }
}

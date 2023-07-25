package org.bumbumapps.privacyfriendlymemory;

import android.content.Context;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import org.bumbumapps.privacyfriendlymemory.ui.R;

public class BannersLoader {
    public static void showGoogleBannerAd(Context context, AdView bannerView) {
        bannerView.setVisibility(View.VISIBLE);
        MobileAds.initialize(context, (OnInitializationCompleteListener) new OnInitializationCompleteListener() {
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        bannerView.loadAd(new AdRequest.Builder().build());
    }
}

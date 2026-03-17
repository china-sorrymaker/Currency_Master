package com.boss.unitsmaster;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1. 确保你的 layout 名字叫 activity_main
        setContentView(R.layout.activity_main);

        // 2. 初始化 AdMob (这一步没做也会闪退)
        MobileAds.initialize(this, initializationStatus -> {});

        // 3. 加载广告 (前提是你的 XML 里得有 adView 这个 ID)
        AdView mAdView = findViewById(R.id.adView);
        if (mAdView != null) {
            AdRequest adRequest = new AdRequest.Builder().build();
            mAdView.loadAd(adRequest);
        }
    }
}

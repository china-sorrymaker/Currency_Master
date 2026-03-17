package com.boss.unitsmaster;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobileAds.initialize(this, status -> {});
    }
    protected void loadBanner(int id) {
        AdView v = findViewById(id);
        if (v != null) v.loadAd(new AdRequest.Builder().build());
    }
}

package com.boss.unitsmaster;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 必须改成 activity_main，对应你截图里的那个文件名
        setContentView(R.layout.activity_main);

        // 1. 初始化广告
        MobileAds.initialize(this, status -> {});
        AdView mAdView = findViewById(R.id.adView);
        if (mAdView != null) {
            mAdView.loadAd(new AdRequest.Builder().build());
        }

        // 2. BMI 业务逻辑
        EditText etHeight = findViewById(R.id.etHeight);
        EditText etWeight = findViewById(R.id.etWeight);
        Button btnCalculate = findViewById(R.id.btnCalculate);
        TextView tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(v -> {
            String hStr = etHeight.getText().toString();
            String wStr = etWeight.getText().toString();
            
            if (!hStr.isEmpty() && !wStr.isEmpty()) {
                float height = Float.parseFloat(hStr) / 100; // 厘米转米
                float weight = Float.parseFloat(wStr);
                float bmi = weight / (height * height);
                
                String level = (bmi < 18.5) ? "偏瘦" : (bmi < 24) ? "正常" : "偏胖";
                tvResult.setText(String.format("BMI: %.2f\n状态: %s", bmi, level));
            }
        });
    }
}

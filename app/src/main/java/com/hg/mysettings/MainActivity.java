package com.hg.mysettings;

import android.content.Intent;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.hg.mysettings.ui.AppManagerActivity;
import com.hg.mysettings.ui.DeviceInfoActivity;
import com.hg.mysettings.ui.ItvSetActivity;
import com.hg.mysettings.ui.NetworkManagerActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG = "MainActivity";
    private Button mbtnItvSet;
    private Button mbtnNetDetection;
    private Button mbtnScreenSet;
    private Button mbtnSchemeSet;
    private Button mbtnNetSet;
    private Button mbtnAppManager;
    private Button mbtnMore;
    private Button mbtnDeviceInfo;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mbtnItvSet = (Button) findViewById(R.id.home_itv_set);
        mbtnNetDetection = (Button) findViewById(R.id.home_net_detection);
        mbtnScreenSet = (Button) findViewById(R.id.home_screen_set);
        mbtnSchemeSet = (Button) findViewById(R.id.home_scheme_set);
        mbtnNetSet = (Button) findViewById(R.id.home_net_set);
        mbtnAppManager = (Button) findViewById(R.id.home_app_manager);
        mbtnMore = (Button) findViewById(R.id.home_more);
        mbtnDeviceInfo = (Button) findViewById(R.id.home_device_info);

        mbtnItvSet.setOnClickListener(this);
        mbtnNetDetection.setOnClickListener(this);
        mbtnScreenSet.setOnClickListener(this);
        mbtnSchemeSet.setOnClickListener(this);
        mbtnNetSet.setOnClickListener(this);
        mbtnAppManager.setOnClickListener(this);
        mbtnMore.setOnClickListener(this);
        mbtnDeviceInfo.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.home_itv_set:
                intent = new Intent(this, ItvSetActivity.class);
                break;
            case R.id.home_net_detection:
                break;
            case R.id.home_screen_set:
                break;
            case R.id.home_scheme_set:
                break;
            case R.id.home_net_set:
                intent = new Intent(this, NetworkManagerActivity.class);
                break;
            case R.id.home_app_manager:
                this.intent = new Intent(this, AppManagerActivity.class);
                break;
            case R.id.home_more:
                break;
            case R.id.home_device_info:
                this.intent = new Intent(this, DeviceInfoActivity.class);
                break;
        }
        if (intent != null) {
            startActivity(intent);
        }
    }
}

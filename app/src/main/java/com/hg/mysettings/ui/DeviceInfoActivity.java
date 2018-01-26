package com.hg.mysettings.ui;

import android.app.DevInfoManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.hg.mysettings.R;


public class DeviceInfoActivity extends AppCompatActivity {
    private static final String TAG = "DeviceInfoActivity";
    private TextView tvStbModle;
    private TextView tvSoftwareId;
    private TextView tvSettingsId;
    private TextView tvSerialNum;
    private TextView tvMac;
    private TextView tvNetId;
    private TextView tvServiceId;
    private TextView tvServiceGroup;
    private TextView tvAuthUrl;
    private TextView tvUpgradeUrl;
    private TextView tvManufactureName;
    private TextView tvLauncherVersion;
    private String mModel;
    private String mSoftwareVersion;
    private String mSN;
    private String mMAC;
    private String mUserID;
    private String mIPTVauthURL;
    private String mUpgradeService2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_info);
        initParam();
        iniView();

    }

    private void initParam() {
        DevInfoManager mDevInfoManager = (DevInfoManager) getSystemService("devinfo_data");
        mModel = mDevInfoManager.getValue("STB.Model");
        mSoftwareVersion = mDevInfoManager.getValue("STB.SoftwareVersion");
        mSN = mDevInfoManager.getValue("STB.SN");
        mMAC = mDevInfoManager.getValue("STB.MAC");
        mUserID = mDevInfoManager.getValue("STB.UserID");
        mIPTVauthURL = mDevInfoManager.getValue("STB.IPTVauthURL");
        mUpgradeService2 = mDevInfoManager.getValue("STB.UpgradeService2");
    }

    private void iniView() {
        tvStbModle = (TextView) findViewById(R.id.id_stb_modle);
        tvSoftwareId = (TextView) findViewById(R.id.id_software_id);
        tvSettingsId = (TextView) findViewById(R.id.id_settings_id);
        tvSerialNum = (TextView) findViewById(R.id.id_serial_num);
        tvMac = (TextView) findViewById(R.id.id_mac);
        tvNetId = (TextView) findViewById(R.id.id_net_id);
        tvServiceId = (TextView) findViewById(R.id.id_service_id);
        tvServiceGroup = (TextView) findViewById(R.id.id_service_group);
        tvAuthUrl = (TextView) findViewById(R.id.id_authUrl);
        tvUpgradeUrl = (TextView) findViewById(R.id.id_upgrade_url);
        tvManufactureName = (TextView) findViewById(R.id.id_manufacture_name);
        tvLauncherVersion = (TextView) findViewById(R.id.id_launcher_version);

        tvStbModle.setText(mModel);
        tvSoftwareId.setText(mSoftwareVersion);
        tvSerialNum.setText(mSN);
        tvMac.setText(mMAC);
        tvServiceId.setText(mUserID);
        tvAuthUrl.setText(mIPTVauthURL);
        tvUpgradeUrl.setText(mUpgradeService2);
    }
}

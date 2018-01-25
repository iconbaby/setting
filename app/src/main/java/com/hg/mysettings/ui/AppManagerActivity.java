package com.hg.mysettings.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.StatFs;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hg.mysettings.R;
import com.hg.mysettings.adapter.AppManagerAdapter;
import com.hg.mysettings.model.AppInfo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class AppManagerActivity extends Activity {
    private static final String TAG = "AppManagerActivity";
    private TextView mTVStorageTotal;
    private TextView mTvStorageAvaliable;
    private ProgressBar mProgressBar;
    private ListView mListView;
    private List<AppInfo> mAppInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app_manager);
        initView();
    }

    private void initView() {
        mTVStorageTotal = (TextView) findViewById(R.id.app_manage_storage_total);
        mTvStorageAvaliable = (TextView) findViewById(R.id.app_manage_storage_available);
        mProgressBar = (ProgressBar) findViewById(R.id.app_manager_pb);
        mListView = (ListView) findViewById(R.id.app_manage_lv);

        initStorage();
        initHadInstallApp();
    }

    /**
     * @date : 2018/1/25
     * @author : slkk
     * @description: has install app
     * @parampters:
     */
    private void initHadInstallApp() {
        mAppInfoList = queryAppInfo();
        Log.i(TAG, "initHadInstallApp: " + mAppInfoList.size());
        AppManagerAdapter appManagerAdapter = new AppManagerAdapter(this, mAppInfoList);
        mListView.setAdapter(appManagerAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i(TAG, "onItemClick: " + position);
                popAppinfoDetailDialog(position);

            }
        });
    }

    private void popAppinfoDetailDialog(int position) {
        AlertDialog alertDialog = new AlertDialog.Builder(this).create();
        LinearLayout dialogView = (LinearLayout) getLayoutInflater().inflate(R.layout.layout_appinfo_detail, null);
        alertDialog.setView(dialogView);
        alertDialog.show();

    }

    private List<AppInfo> queryAppInfo() {
        ArrayList<AppInfo> appInfoList = new ArrayList<AppInfo>();
        PackageManager pm = getPackageManager();
        List<PackageInfo> installedPackages = pm.getInstalledPackages(0);
        for (PackageInfo pkinfo : installedPackages) {
            Drawable icon = pkinfo.applicationInfo.loadIcon(pm);
            String label = (String) pkinfo.applicationInfo.loadLabel(pm);
            Log.i(TAG, "queryAppInfo: " + label);
            AppInfo appInfo = new AppInfo();
            appInfo.setAppIcon(icon);
            appInfo.setAppLabel(label);
            appInfoList.add(appInfo);
        }
        return appInfoList;
    }

    /**
     * @date : 2018/1/25
     * @author : slkk
     * @description: init storage view
     * @parampters:
     */
    private void initStorage() {

        double totalStorage = getTotalInternalMemorySize() / (1024.00 * 1024.00 * 1024.00);
        double avaliableStorage = getAvailableInternalMemorySize() / (1024.00 * 1024.00 * 1024.00);
        mTVStorageTotal.setText(String.format("%.2f", totalStorage));
        mTvStorageAvaliable.setText(String.format("%.2f", avaliableStorage));
        mProgressBar.setProgress((int) (((totalStorage - avaliableStorage) / totalStorage) * 100));
        Log.i(TAG, "initStorage: " + ((totalStorage - avaliableStorage) / totalStorage) * 100);

    }


    /**
     * @date : 2018/1/25
     * @author : slkk
     * @description:内部可用存储
     * @parampters:
     */
    public long getAvailableInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return availableBlocks * blockSize;
    }


    /**
     * @date : 2018/1/25
     * @author : slkk
     * @description:内部总存储
     * @parampters:
     */
    public long getTotalInternalMemorySize() {
        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long totalBlocks = stat.getBlockCount();
        return totalBlocks * blockSize;
    }

    public boolean externalMemoryAvailable() {
        return Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
    }


    /**
     * @date : 2018/1/25
     * @author : slkk
     * @description: 外部可用存储
     * @parampters:
     */
    public long getAvailableExternalMemorySize() {
        if (externalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long availableBlocks = stat.getAvailableBlocks();
            return availableBlocks * blockSize;
        } else {
            return -1;
        }
    }

    /**
     * @date : 2018/1/25
     * @author : slkk
     * @description: 外部总存储
     * @parampters:
     */

    public long getTotalExternalMemorySize(String s) {
        if (externalMemoryAvailable()) {
            File path = Environment.getExternalStorageDirectory();
            StatFs stat = new StatFs(path.getPath());
            long blockSize = stat.getBlockSize();
            long totalBlocks = stat.getBlockCount();
            return totalBlocks * blockSize;
        } else {
            return -1;
        }
    }


}

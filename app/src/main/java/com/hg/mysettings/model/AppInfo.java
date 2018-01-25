package com.hg.mysettings.model;

import android.graphics.drawable.Drawable;

/**
 * @date: 2018/1/25
 * @author: slkk
 * @description:
 */
public class AppInfo {
    private String appLabel;
    private Drawable appIcon;
    private float appSize;
    private float dataSize;
    private float cacheSize;
    private float totalSize;

    public String getAppLabel() {
        return appLabel;
    }

    public void setAppLabel(String appLabel) {
        this.appLabel = appLabel;
    }

    public Drawable getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(Drawable appIcon) {
        this.appIcon = appIcon;
    }

    public float getAppSize() {
        return appSize;
    }

    public void setAppSize(float appSize) {
        this.appSize = appSize;
    }

    public float getDataSize() {
        return dataSize;
    }

    public void setDataSize(float dataSize) {
        this.dataSize = dataSize;
    }

    public float getCacheSize() {
        return cacheSize;
    }

    public void setCacheSize(float cacheSize) {
        this.cacheSize = cacheSize;
    }

    public float getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(float totalSize) {
        this.totalSize = totalSize;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    private String version;
}

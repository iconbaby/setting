package com.hg.mysettings.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.hg.mysettings.R;
import com.hg.mysettings.model.AppInfo;

import org.w3c.dom.Text;

import java.util.List;


/**
 * @date: 2018/1/25
 * @author: slkk
 * @description:
 */
public class AppManagerAdapter extends BaseAdapter {
    private List<AppInfo> mAppInfoList;
    private LayoutInflater mInflater;
    private static final String TAG = "AppManagerAdapter";
    public AppManagerAdapter(Context context, List<AppInfo> appInfoList) {
        this.mInflater = LayoutInflater.from(context);
        this.mAppInfoList = appInfoList;
    }

    @Override
    public int getCount() {
        return mAppInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAppInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            Log.i(TAG, "getView: convertView == null");
            convertView = mInflater.inflate(R.layout.item_appinfo_listview, null);
            viewHolder = new ViewHolder();
            viewHolder.appIcon = (ImageView) convertView.findViewById(R.id.item_appinfo_listview_icon);
            viewHolder.tvAppLabel = (TextView) convertView.findViewById(R.id.item_appinfo_listview_label);
            viewHolder.tvAppSize = (TextView) convertView.findViewById(R.id.item_appinfo_listview_size);
            convertView.setTag(viewHolder);
        } else {
            Log.i(TAG, "getView: convertView != null");
            viewHolder = (ViewHolder) convertView.getTag();
        }
        AppInfo appinfo = (AppInfo) getItem(position);
        viewHolder.appIcon.setImageDrawable(appinfo.getAppIcon());
        viewHolder.tvAppLabel.setText(appinfo.getAppLabel());
        return convertView;
    }

    class ViewHolder {
        ImageView appIcon;
        TextView tvAppLabel;
        TextView tvAppSize;

    }
}

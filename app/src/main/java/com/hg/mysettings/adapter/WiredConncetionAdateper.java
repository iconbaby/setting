package com.hg.mysettings.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hg.mysettings.R;


/**
 * @date: 2018/2/5
 * @author: slkk
 * @description:
 */
public class WiredConncetionAdateper extends BaseAdapter {
    private Context mContext;

    public WiredConncetionAdateper(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_wired_connect_listview, null);
            viewHolder = new ViewHolder();
            viewHolder.iv = (ImageView) convertView.findViewById(R.id.item_wired_connect_listview_iv);
            viewHolder.rb = (RadioButton) convertView.findViewById(R.id.item_wired_connect_listview_rb);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.item_wired_connect_listview_tv);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        switch (position) {
            case 0:
                viewHolder.rb.setText(R.string.dial_mode);
                break;
            case 1:
                viewHolder.rb.setText(R.string.dhcp_mode);
                break;
            case 2:
                viewHolder.rb.setText(R.string.static_mode);
                break;
        }
        return convertView;
    }

    class ViewHolder {
        RadioButton rb;
        TextView tv;
        ImageView iv;
    }
}

package com.hg.mysettings.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.hg.mysettings.R;


/**
 * Created by slkk on 18-1-31.
 */

public class ListItem extends RelativeLayout {
    private Context context;
    private ImageView imgItem;
    private ImageView imgLockItem;
    private TextView txtItemLeft;
    private TextView txtItemRight;
    private View view;

    public ListItem(Context context) {
        super(context, null);
        this.context = context;
        initView();
    }
    public ListItem(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.context = context;
        initView();
    }

    public ListItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ListItem);
        this.txtItemLeft.setText(a.getString(R.styleable.ListItem_left_text));

//        LayoutParams params = new LayoutParams(-2, -2);
//        if (minWidthId != R.dimen.m247) {
//            params.width = (int) (137.0f * Config.DENSITY);
//            params.height = (int) (55.0f * Config.DENSITY);
//            params.addRule(16);
//            this.txtItemLeft.setLayoutParams(params);
//        }

        this.txtItemRight.setText(a.getString(R.styleable.ListItem_right_text));
//        setVisibilityRight(a.getBoolean(4, true));
//        setVisibilityImg(a.getBoolean(5, true));
//        boolean flagImgLock = a.getBoolean(6, false);
//        this.imgLockItem.setImageResource(a.getResourceId(2, R.drawable.img_nat_wifi_lock));
//        setVisibilityImgLock(flagImgLock);
        a.recycle();
    }



    private void initView() {
        this.view = LayoutInflater.from(this.context).inflate(R.layout.view_list, this);
        this.txtItemLeft = (TextView) this.view.findViewById(R.id.tv_list_item_left);
        this.txtItemRight = (TextView) this.view.findViewById(R.id.tv_list_item_right);
        setBackgroundResource(R.drawable.item_list_selector);
        setFocusable(true);
    }

    public void setVisibilityRight(boolean flag) {
        if (flag) {
            this.txtItemRight.setVisibility(View.VISIBLE);
        } else {
            this.txtItemRight.setVisibility(View.INVISIBLE);
        }
    }

    public void setVisibilityImg(boolean flag) {
        if (flag) {
            this.imgItem.setVisibility(View.VISIBLE);
        } else {
            this.imgItem.setVisibility(View.INVISIBLE);
        }
    }

    public void requestF() {
        requestFocus();
    }

    public void setVisibilityImgLock(boolean flag) {
        if (flag) {
            this.imgLockItem.setVisibility(View.VISIBLE);
        } else {
            this.imgLockItem.setVisibility(View.INVISIBLE);
        }
    }

    public void setTextRight(String content) {
//        if (content.equals("<unknown ssid>")) {
//            content = getResources().getString(R.string.txt_network_setting_sub_switch_off);
//        }
        this.txtItemRight.setText(content);
    }

    public void setTextLeft(String content) {
        this.txtItemLeft.setText(content);
    }

    public String getTextRight() {
        if (this.txtItemRight != null) {
            return this.txtItemRight.getText().toString();
        }
        return "";
    }

    public void setItemTextColor(int color) {
        if (this.txtItemLeft != null) {
            this.txtItemLeft.setTextColor(color);
        }
        if (this.txtItemRight != null) {
            this.txtItemRight.setTextColor(color);
        }
    }
}

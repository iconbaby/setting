package com.hg.mysettings.widgets;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Switch;

import com.hg.mysettings.R;

import java.util.zip.Inflater;

/**
 * Created by slkk on 18-2-5.
 */

public class ListSwitchItem extends LinearLayout {
    private boolean isChecked = false;
    private static final String TAG = "ListSwitchItem";
    private Context mContext;
    private Switch list_switch;
    private LinearLayout list_linearLayout;

    public ListSwitchItem(Context context) {
        super(context);
        this.mContext = context;
        initView();
    }

    public ListSwitchItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        initView();

    }

    private void initView() {
        LayoutInflater.from(this.mContext).inflate(R.layout.item_list_switch, this);
        list_switch = (Switch) findViewById(R.id.list_switch_item_switch);
        list_linearLayout = (LinearLayout) findViewById(R.id.list_switch_item_switch_linearLayout);
        setBackgroundResource(R.drawable.item_list_selector);
        setFocusable(true);
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        Log.i(TAG, "dispatchKeyEvent: " + event.getAction()+"   "+event.getKeyCode());

        if (event.getKeyCode() == KeyEvent.KEYCODE_DPAD_CENTER && event.getAction() == KeyEvent.ACTION_UP) {
            if (!isChecked) {
                list_switch.setChecked(true);
                isChecked = true;
            } else if (isChecked) {
                list_switch.setChecked(false);
                isChecked = false;
            }
        }

        return super.dispatchKeyEvent(event);
    }
}

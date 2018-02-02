package com.hg.mysettings.ui;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.hg.mysettings.R;
import com.hg.mysettings.widgets.ListItem;

import java.util.HashMap;

public class NetworkManagerActivity extends Activity {
    private static final String TAG = "NetworkManagerActivity";
    private HashMap<String, Integer> ha = new HashMap<String, Integer>();
    private RadioGroup radioGroup;
    private RadioButton rb_wired;
    private RadioButton rb_other;
    private ListItem listItem_wired;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network_manager);
//        showPasswordDialog();
        initView();
    }

    private void initView() {
        listItem_wired = (ListItem) findViewById(R.id.network_manager_listitem_wired);
        listItem_wired.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "onClick: ");
                Intent intent = new Intent();
                intent.setClass(NetworkManagerActivity.this, WiredConnectionActivity.class);
                startActivity(intent);
            }
        });

        radioGroup = (RadioGroup) findViewById(R.id.network_manager_rg_connect_mode);
        rb_wired = (RadioButton) findViewById(R.id.network_manager_rb_wired_connect);
        rb_other = (RadioButton) findViewById(R.id.network_manager_rb_other_connect);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.network_manager_rb_wired_connect:
                        Log.i(TAG, "onCheckedChanged: network_manager_rb_wired_connect");
                        break;
                    case R.id.network_manager_rb_other_connect:
                        Log.i(TAG, "onCheckedChanged: network_manager_rb_other_connect");
                        break;
                }
            }
        });

    }

    private void showPasswordDialog() {
        final AlertDialog passwordDialog = new AlertDialog.Builder(this).create();
        LinearLayout dialogView = (LinearLayout) getLayoutInflater().inflate(R.layout.layout_password_dialog, null);
        passwordDialog.setView(dialogView);
        final EditText input_password = (EditText) dialogView.findViewById(R.id.password_dialog_input);
        Button btn_ok = (Button) dialogView.findViewById(R.id.password_dialog_btn_ok);
        Button btn_cancle = (Button) dialogView.findViewById(R.id.password_dialog_btn_cancle);
        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String password = input_password.getText().toString();
                if (!TextUtils.isEmpty(password) && password.equals("6321")) {
                    passwordDialog.dismiss();
                } else {
                    input_password.setText("");
                    input_password.setHint("密码错误，请重新输入");

                }

            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NetworkManagerActivity.this.finish();

            }
        });
        passwordDialog.setCancelable(false);
        passwordDialog.show();
    }
}

package com.hg.mysettings.ui;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.hg.mysettings.R;

public class ItvSetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itv_set);
        showPasswordDialog();
        initView();
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
                }else{
                    input_password.setText("");
                    input_password.setHint("密码错误，请重新输入");

                }

            }
        });

        btn_cancle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ItvSetActivity.this.finish();

            }
        });
        passwordDialog.setCancelable(false);
        passwordDialog.show();
    }

    private void initView() {
    }

}

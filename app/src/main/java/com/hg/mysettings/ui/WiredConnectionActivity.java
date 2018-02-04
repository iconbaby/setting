package com.hg.mysettings.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.hg.mysettings.R;
import com.hg.mysettings.adapter.WiredConncetionAdateper;
import com.hg.mysettings.widgets.ListSwitchItem;

public class WiredConnectionActivity extends AppCompatActivity {

    private ListView lv;
    private ListSwitchItem lsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wired_connection);
        initView();
    }

    private void initView() {
        lv = (ListView) findViewById(R.id.wired_connection_lv);
        lsi = (ListSwitchItem) findViewById(R.id.wired_connection_lsi);
        lv.setAdapter(new WiredConncetionAdateper(this));
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }
        });
    }
}

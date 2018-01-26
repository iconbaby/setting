package com.hg.recyclerviewdemo;

import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private ArrayList<String> datas;
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initDate();
        for (String i : datas) {
            Log.i(TAG, "onCreate: " + i);
        }
        recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
//        recyclerView.setLayoutManager(new GridLayoutManager(this,4));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(new MyAdater());

    }

    private void initDate() {
        datas = new ArrayList<String>();
        for (int i = 'A'; i < 'z'; i++) {
            datas.add((char) i + "");
        }
    }

    class MyAdater extends RecyclerView.Adapter<MyAdater.MyViewHolder> {

        @Override
        public MyAdater.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            MyViewHolder myViewHolder = new MyViewHolder(LayoutInflater.from(MainActivity.this).inflate(R.layout.item_recycler, parent, false));
            return myViewHolder;
        }

        @Override
        public void onBindViewHolder(MyAdater.MyViewHolder holder, int position) {

            holder.tv.setText(datas.get(position));
        }

        @Override
        public int getItemCount() {
            return datas.size();
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.id_recyclerView_tv);//注意这个地方是itemView.findViewById
            }
        }
    }
}

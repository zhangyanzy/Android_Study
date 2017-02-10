package com.tarenwang.android_study.spinner;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.tarenwang.android_study.R;

import java.util.ArrayList;
import java.util.List;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView mTv;
    private Spinner msp;

    private List<String> list;

    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)  {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        //mTv.setText("您选择的城市是：");
        init();
        setData();
        /**
         *  2.新建数组适配器（ArrayAdapter）--单独文字使用方便
         */
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, list);

        /**
         *  3.adapter 设置一个下拉列表样式
         */
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        /**
         *  4.Spinner 加载适配器
         */
        msp.setAdapter(adapter);

        /**
         *  5 spinner设置监听器
         */
        msp.setOnItemSelectedListener(this);
    }

    private void init() {
        mTv = (TextView) findViewById(R.id.textview);
        msp = (Spinner) findViewById(R.id.spinner);
    }

    /**
     * 1、设置数据源
     */
    private void setData() {
        list = new ArrayList<String>();
        list.add("北京");
        list.add("上海");
        list.add("广州");
        list.add("深圳");

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        String city = adapter.getItem(position);
        mTv.setText("您选择的城市是："+city);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}

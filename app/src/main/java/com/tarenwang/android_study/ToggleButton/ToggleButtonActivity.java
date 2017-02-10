package com.tarenwang.android_study.ToggleButton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import com.tarenwang.android_study.R;

public class ToggleButtonActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private ToggleButton mTb;
    private ImageView mIm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);
        init();
        /**
         * 给当前的ToggleButton设置监听器
         * */
        mTb.setOnCheckedChangeListener(this);
    }

    private void init() {
        mTb = (ToggleButton) findViewById(R.id.toggleButton);
        mIm = (ImageView) findViewById(R.id.imageView);
    }


    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        /**
         * 当ToggleButton被点击的时候，当前的方法会执行
         *
         * buttonView -- 代表被点击控件的本身
         * isChecked -- 代表被点击的控件状态
         *
         */
        if (isChecked == true){
            mIm.setBackgroundResource(R.mipmap.on);
        }else {
            mIm.setBackgroundResource(R.mipmap.off);
        }
    }
}

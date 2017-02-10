package com.tarenwang.android_study.RadioButton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.tarenwang.android_study.R;

public class RadioButtonActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener {

    private RadioGroup mRg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio_button);
        init();
    }

    private void init() {
        mRg = (RadioGroup) findViewById(R.id.radioRroup);

        mRg.setOnCheckedChangeListener(this);
    }

    /**
     * RadioButton 监听事件
     *
     * @param group
     * @param checkedId
     */

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.man_radio:
                Log.i("asd", "男");
                Toast.makeText(getApplicationContext(),"男",Toast.LENGTH_SHORT).show();
                break;
            case R.id.woman_radio:
                Log.i("asd", "女");
                Toast.makeText(getApplicationContext(),"女",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}

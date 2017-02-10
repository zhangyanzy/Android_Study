package com.tarenwang.android_study.GridView;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.tarenwang.android_study.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * 1、准备数据源
 * 2、新建适配器（SimpleAdapter）
 * 3、GridView加载适配器
 * 4、GridView加载事件监听
 */

public class GridViewActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private GridView mGv;
    //SimpleAdapter的集合是特殊的集合MAP中又有键值对
    private List<Map<String, Object>> datalist;
    //图片封装到int形数组中
    private int[] icon = {R.mipmap.address_book, R.mipmap.calendar, R.mipmap.camera, R.mipmap.clock,
            R.mipmap.games_control, R.mipmap.messenger, R.mipmap.ringtone, R.mipmap.settings,
            R.mipmap.speech_balloon, R.mipmap.weather, R.mipmap.world, R.mipmap.youtube};
    //文字也封装到String形式数组中
    private String[] iconName = {"通讯录", "日历", "照相机", "时钟", "游戏", "短信", "铃声", "设置", "语音", "天气", "浏览器", "视频",};
    //生成一个适配器
    private SimpleAdapter simpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        datalist = new ArrayList<Map<String, Object>>();
        init();
        //getData();
        /**
         * 2--新建适配器
         *   上下文
         *   数据源
         *   item的布局文件
         *   数组的名称
         *   item中空间的名称
         */
        simpleAdapter = new SimpleAdapter(this,
                getData(),
                R.layout.item,
                new String[]{"image", "text"},
                new int[]{R.id.item_image, R.id.item_textview});
        /**
         * GridView加载适配器
         */
        mGv.setAdapter(simpleAdapter);
        mGv.setOnItemClickListener(this);
    }

    private void init() {
        mGv = (GridView) findViewById(R.id.gridview);
    }

    public List<Map<String, Object>> getData() {
        //用循环去添加图片和文件
        for (int i = 0;i<icon.length;i++){
            //开启数据
            Map<String,Object> map = new HashMap<String, Object>();
            //已键值对的形式去放入图片和文字
            map.put("image",icon[i]);
            map.put("text",iconName[i]);
            //加入
            datalist.add(map);
        }


        return datalist;
    }

    /**
     *  事件监听器
     */

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(this,iconName[position],Toast.LENGTH_SHORT).show();

    }
}

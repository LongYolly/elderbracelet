package com.bt.elderbracelet.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import com.bonten.ble.application.MyApplication;
import com.bt.elderbracelet.adapter.ClockAdapter;
import com.bt.elderbracelet.entity.ClockEntity;
import com.bt.elderbracelet.entity.SleepClock;
import com.bt.elderbracelet.entity.others.Event;
import com.bt.elderbracelet.tools.MethodUtils;
import com.bt.elderbracelet.tools.SpHelp;
import com.bt.elderbracelet.view.TitleView;
import com.bt.elderbracelet.view.TitleView.onBackLister;
import com.bttow.elderbracelet.R;

import java.util.ArrayList;

import de.greenrobot.event.EventBus;

/**
 * @author Administrator
 *         闹钟提醒详情类
 */
public class SleepRemindActicvity extends Activity {

    private TitleView titleView;// 标题栏
    private ListView listview;
    private ArrayList<ClockEntity> clockList = null;
    SleepClock entity = null;
    private ClockAdapter clockAdapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.bracelet_clock_remind);
        MyApplication.getInstance().addActivity(this);
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView()
    {
        titleView = (TitleView) findViewById(R.id.titleview);
        titleView.setTitle(R.string.sleep_remind);
        titleView.setcolor("#a9d559");
        titleView.settextcolor("#ffffff");
        titleView.titleImg(R.drawable.sleep_icon);
        titleView.setBack(R.drawable.steps_back, new onBackLister() {
            @Override
            public void onClick(View button)
            {
                finish();
            }
        });
        listview = (ListView) findViewById(R.id.clock_listview);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id)
            {
                Intent intent = new Intent(SleepRemindActicvity.this, SleepRemindDetailsActivity.class);
                SleepClock clock = (SleepClock) parent.getItemAtPosition(position);
                intent.putExtra("clock", clock);
                startActivity(intent);
            }
        });
    }

    //也就是说，这个方法实质上是给 clockList 赋值
    private void initData()  //这个方法写得好
    {
        if (clockList == null) {
            clockList = new ArrayList<>();
        }
        if (clockList.size() > 0) {
            clockList.clear();
        }
        if (clockAdapter != null) {
            clockAdapter.notifyDataSetChanged();
        }

        for (int i = 0; i < 5; i++) {

            if (SpHelp.getObject(SpHelp.getSleepClockKey(i)) != null) {
                entity = (SleepClock) SpHelp.getObject(SpHelp.getSleepClockKey(i));
                clockList.add(entity);
            } else {
                entity = new SleepClock();
                entity.id = i;
                clockList.add(entity);
                String key = SpHelp.getSleepClockKey(i);
                SpHelp.saveObject(key, entity);
            }
        }

        clockAdapter = new ClockAdapter(getApplicationContext(), clockList, ClockAdapter.KIND_SLEEP_CLOCK);
        listview.setAdapter(clockAdapter);

    }


    public void onEventMainThread(Event event)
    {
        if (event.update_sleep_remind) {
            if (MyApplication.cb_switch) {
                MethodUtils.showToast(getApplicationContext(), "睡眠提醒打开!");
            } else {
                MethodUtils.showToast(getApplicationContext(), "睡眠提醒关闭!");
            }
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        initData();
    }

    @Override
    protected void onDestroy()
    {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}

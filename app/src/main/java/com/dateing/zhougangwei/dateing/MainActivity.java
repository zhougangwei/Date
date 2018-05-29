package com.dateing.zhougangwei.dateing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BadgeItem;

public class MainActivity extends AppCompatActivity {

    //private int[] titleIds = {R.string.main, R.string.down, R.string.my};
    private BadgeItem mBadgeItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initBottomBar();
    }

    private void initBottomBar() {


    }

    private void initBottomNavigation() {

        /*//底边栏主页
        BottomNavigationItem MainItem = new BottomNavigationItem(R.mipmap.sy_pre, titleIds[0]);

             *//* MainItem.setActiveColorResource(R.color.btn_normal);//选中的颜色
                MainItem.setActiveColorResource();//没选中的颜色*//*
        mBottomNavigationBar.addItem(MainItem);



        //底边栏下载
        BottomNavigationItem DownItem = new BottomNavigationItem(R.mipmap.xz_pre, titleIds[1]);
        //        DownItem.setActiveColor(getResources().getColor(R.color.btn_normal));//选中的颜色
        //        DownItem.setInActiveColor(getResources().getColor(R.color.inActive));//没选中的颜色
        mBadgeItem = new BadgeItem();
        mBadgeItem.setGravity(Gravity.RIGHT);
        mBadgeItem.setTextColorResource(R.color.white);
        mBadgeItem.setBackgroundColor(R.color.red);
        updateUnreadCount();            //用来显示 数据的
        DownItem.setBadgeItem(mBadgeItem);
        mBottomNavigationBar.addItem(DownItem);


        BottomNavigationItem pluginItem = new BottomNavigationItem(R.mipmap.yh_pre, titleIds[2]);
        //        pluginItem.setActiveColor(getResources().getColor(R.color.btn_normal));//选中的颜色
        //        pluginItem.setInActiveColor(getResources().getColor(R.color.inActive));//没选中的颜色
        mBottomNavigationBar.addItem(pluginItem);

        mBottomNavigationBar.setActiveColor(R.color.Active);
        mBottomNavigationBar.setInActiveColor(R.color.inActive);

        mBottomNavigationBar.initialise();

        mBottomNavigationBar.setTabSelectedListener(this);*/
    }

}

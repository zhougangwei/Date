package com.dateing.zhougangwei.dateing;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.ashokvarma.bottomnavigation.BadgeItem;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.dateing.zhougangwei.dateing.base.BaseFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.fl_content)
    FrameLayout flContent;
    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    private int[] titleIds = {R.string.main, R.string.down, R.string.my};
    private BadgeItem mBadgeItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBottomNavigation();
    }


    private void initBottomNavigation() {

        //底边栏主页
        BottomNavigationItem MainItem = new BottomNavigationItem(R.mipmap.ic_launcher, titleIds[0]);

        MainItem.setActiveColorResource(R.color.challenge_content_color);//选中的颜色
        mBottomNavigationBar.addItem(MainItem);


        //底边栏下载
        BottomNavigationItem DownItem = new BottomNavigationItem(R.mipmap.ic_launcher, titleIds[1]);
        //        DownItem.setActiveColor(getResources().getColor(R.color.btn_normal));//选中的颜色
        //        DownItem.setInActiveColor(getResources().getColor(R.color.inActive));//没选中的颜色
        mBadgeItem = new BadgeItem();
        mBadgeItem.setGravity(Gravity.RIGHT);
        mBadgeItem.setTextColorResource(R.color.white);
        mBadgeItem.setBackgroundColor(R.color.find_title_color);
        //updateUnreadCount();            //用来显示 数据的
        DownItem.setBadgeItem(mBadgeItem);
        mBottomNavigationBar.addItem(DownItem);


        BottomNavigationItem pluginItem = new BottomNavigationItem(R.mipmap.ic_launcher, titleIds[2]);
        //        pluginItem.setActiveColor(getResources().getColor(R.color.btn_normal));//选中的颜色
        //        pluginItem.setInActiveColor(getResources().getColor(R.color.inActive));//没选中的颜色
        mBottomNavigationBar.addItem(pluginItem);

        mBottomNavigationBar.setActiveColor(R.color.challenge_content_color);
        mBottomNavigationBar.setInActiveColor(R.color.challenge_content_color);

        mBottomNavigationBar.initialise();

        mBottomNavigationBar.setTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(int position) {
/**
 * 先判断当前Fragment是否被添加到了MainActivity中
 * 如果添加了则直接显示即可
 * 如果没有添加则添加，然后显示
 */
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        BaseFragment fragment = FragmentFactory.getFragment(position);
        if (!fragment.isAdded()) {
            // addFragment(getFragmentContentId(),fragment,""+position);
            transaction.add(getFragmentContentId(), fragment, "" + position);
        }
        transaction.show(fragment).commit();

        mTvTitle.setText(titleIds[position]);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }
}

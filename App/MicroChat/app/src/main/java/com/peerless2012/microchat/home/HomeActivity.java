package com.peerless2012.microchat.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseActivity;
import com.peerless2012.microchat.base.BaseFragment;
import com.peerless2012.microchat.home.contacts.ContactsFragment;
import com.peerless2012.microchat.home.conversions.ConversationsFragment;
import com.peerless2012.microchat.home.driftbottle.DriftBottleFragment;
import com.peerless2012.microchat.home.moments.MomentsFragment;
import com.peerless2012.microchat.home.nearby.PeopleNearByFragment;
import com.peerless2012.microchat.home.news.NewsFragment;
import com.peerless2012.microchat.home.scan.ScanQRCodeFragment;
import com.peerless2012.microchat.home.shake.ShakeFragment;

import java.util.ArrayList;
import io.realm.Realm;
import io.realm.RealmResults;

public class HomeActivity extends BaseActivity
        implements NavigationView.OnNavigationItemSelectedListener,View.OnClickListener {
    private static final String TAG = "RealmTest";
    private Realm mRealm;

    // Drawer
    private DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private View mDrawerHeaderView;

    //headerview
    private ImageView mHeaderBg;
    private ImageView mHeaderIcon;
    private TextView mHeaderName;

    @Override
    protected int getContentLayout() {
        return R.layout.activity_home;
    }

    @Override
    protected void initView() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        mNavigationView = (NavigationView) findViewById(R.id.nav_view);

        // headerview
        mDrawerHeaderView = mNavigationView.getHeaderView(0);
        mHeaderIcon = getView(mDrawerHeaderView,R.id.drawer_header_icon);
        mHeaderBg = getView(mDrawerHeaderView,R.id.drawer_header_bg);
        mHeaderName = getView(mDrawerHeaderView,R.id.drawer_header_name);

        changeFragment(ConversationsFragment.class,getString(R.string.fragment_conversions_tag),null);
        setTitle(((BaseFragment)preFragment).getTitle());
        changeTitle();
    }

    @Override
    protected void initListener() {
        mNavigationView.setNavigationItemSelectedListener(this);
        mDrawerHeaderView.findViewById(R.id.drawer_header_edit).setOnClickListener(this);
    }

    @Override
    protected void initData() {
        mRealm = Realm.getDefaultInstance();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        int id = item.getItemId();
        Class<? extends Fragment> clazz = null;
        int tagRes = -1;
        Bundle bundle = null;
        if (id == R.id.drawer_chats) { // 会话

            clazz = ConversationsFragment.class;
            tagRes = R.string.fragment_conversions_tag;

        } else if (id == R.id.drawer_contacts) {//联系人

            clazz = ContactsFragment.class;
            tagRes = R.string.fragment_contacts_tag;

        } else if (id == R.id.drawer_moments) {//动态

            clazz = MomentsFragment.class;
            tagRes = R.string.fragment_moments_tag;

        } else if (id == R.id.drawer_scan_qr_code) {//扫描二维码

            clazz = ScanQRCodeFragment.class;
            tagRes = R.string.fragment_scan_qr_tag;

        } else if (id == R.id.drawer_shake) {//摇一摇

            clazz = ShakeFragment.class;
            tagRes = R.string.fragment_shake_tag;

        } else if (id == R.id.drawer_people_nearby) {//附近的人

            clazz = PeopleNearByFragment.class;
            tagRes = R.string.fragment_nearby_tag;

        }else if (id == R.id.drawer_drift_bottle){//漂流瓶

            clazz = DriftBottleFragment.class;
            tagRes = R.string.fragment_drift_bottle_title;

        }else if (id == R.id.drawer_games){//游戏
            clazz = NewsFragment.class;
            tagRes = R.string.fragment_news_tag;
        }
        changeFragment(clazz,getString(tagRes),bundle);
        changeTitle();
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void testCreate(){
        int offset = 0;
        People people = null;
        ArrayList<People> peoples = new ArrayList<People>();
        for (int i = 0; i < 10; i++) {
            people = new People();
            people.setName("名字 ： "+(i + offset));
            people.setAge(i+offset);
            peoples.add(people);
        }
        mRealm.beginTransaction();
        mRealm.copyToRealm(peoples);
        mRealm.commitTransaction();
    }

    public void testGet(){
        RealmResults<People> peoples = mRealm.where(People.class).findAll();
        if (peoples == null) {
            Log.i(TAG, "testGet: People");
        }else {
            for (int i = 0; i < peoples.size(); i++) {
                Log.i(TAG, "testGet: People" + peoples.get(i).toString());
            }
        }
    }

    private Fragment preFragment;

    /**
     * @param fragmentClazz Fragment的完整类名
     * @param data 切换fragment需要携带的数据
     */
    private void changeFragment(Class<? extends Fragment> fragmentClazz, String tag, Bundle data) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        //根据tag找到对应的Fragment
        Fragment currentFragment = fragmentManager.findFragmentByTag(tag);
        //如果选中的就是现在显示的，直接返回（如果需求不同则去掉本行）
        if (currentFragment != null && currentFragment == preFragment) return;
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (currentFragment == null) {

            //参数对应到函数的注释上面,这样写的好处是，如果fragment被回收，在fragment被重新创建的时候会携带之前传递的数据
            currentFragment = Fragment.instantiate(this, fragmentClazz.getName(), data);
            transaction.add(R.id.content, currentFragment, tag);
            if (preFragment != null) {
                transaction.hide(preFragment);
            }
        }else {
            transaction.hide(preFragment);
            transaction.show(currentFragment);
        }
        preFragment = currentFragment;
        transaction.commit();
    }

    private void changeTitle(){
        BaseFragment baseFragment = (BaseFragment) preFragment;
        setTitle(getString(baseFragment.getTitle()));
    }

    public static void launch(Context context){
        Intent intent = new Intent(context,HomeActivity.class);
        context.startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.drawer_header_edit:
                Log.i(TAG, "onClick: 编辑个人信息");
                break;
        }
    }
}

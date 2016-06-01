package com.peerless2012.microchat.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseActivity;
import com.peerless2012.microchat.login.LoginActivity;
import java.util.ArrayList;
import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;
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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

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

        if (id == R.id.drawer_chats) { // 会话

        } else if (id == R.id.drawer_contacts) {//联系人

        } else if (id == R.id.drawer_moments) {//动态

        } else if (id == R.id.drawer_scan_qr_code) {//扫描二维码

        } else if (id == R.id.drawer_shake) {//摇一摇

        } else if (id == R.id.drawer_people_nearby) {//附近的人

        }else if (id == R.id.drawer_drift_bottle){//漂流瓶

        }else if (id == R.id.drawer_games){//游戏

        }

        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void testCreate(){
        int offset = 0;
        People people = null;
        ArrayList<People> peoples = new ArrayList<People>(10);
        for (int i = 0; i < 10; i++) {
            people = new People();
            people.setName("名字 ： "+(i + offset));
            people.setAge(i+offset);
            peoples.add(people);
        }
            people = new People();
            people.setName("名字 ： "+(0 + offset));
            people.setAge(0+offset);
        mRealm.beginTransaction();
        mRealm.copyToRealm(people);
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

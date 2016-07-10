package com.peerless2012.microchat.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.StringRes;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.peerless2012.microchat.R;

/**
* @Author peerless2012
* @Email peerless2012@126.com
* @DateTime 2016/1/15 19:08
* @Version V1.0
* @Description: Activity的基类
*/
 abstract public class BaseActivity extends AppCompatActivity{
    protected String cacheDir;
    protected ViewGroup.LayoutParams contentViewParams;
    protected Toolbar toolbar;
    @Override
    final protected void onCreate(Bundle savedInstanceState) {
        onSaveInstance(savedInstanceState);
        super.onCreate(savedInstanceState);
        initActivity();
        initView();
        initListener();
        initData();
    }
    /**
     * 如果你想获取saveinstance，可以重写此方法
     * @param savedInstanceState
     */
    protected void onSaveInstance(Bundle savedInstanceState){
        // do nothing
    }

    private void initActivity() {
        int contentLayoutRes = getContentLayout();
        if (contentLayoutRes > 0) {
            setContentView(contentLayoutRes);
        }else {
            View contentView = getContentView();
            if (contentView != null) {
                setContentView(contentView,contentViewParams);
            }else {
                throw new IllegalArgumentException("The content view layout res or view is null!");
            }
        }
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null){
            setSupportActionBar(toolbar);
            ActionBar actionBar = getSupportActionBar();
            if (!isHome() && actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);
            }
        }
    }

    protected View getContentView(){
        return null;
    }


    /**
     * 是否是主页,如果不是主页,ToolBar应该是返回模式
     * @return true 如果是主页
     */
    protected boolean isHome(){
        return false;
    }

    /**
     * 获取Activity的布局文件id
     * @return 布局id
     */
    protected abstract int getContentLayout();

    /**
     * 初始化View
     */
    protected abstract void initView();

    /**
     * 初始化监听回调
     */
    protected abstract void initListener();

    /**
     * 初始化数据
     */
    protected abstract void initData();


    protected void setTitle(String title){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(title);
        }
    }

    @CallSuper
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @SuppressWarnings("unchecked")
    protected <T extends View> T getView(Activity activity,int viewResId) {
        return (T)activity.findViewById(viewResId);
    }
    protected <T extends View> T getView(int viewResId) {
        return getView(this,viewResId);
    }
    @SuppressWarnings("unchecked")
    protected <T extends View> T getView(View parent,int viewResId) {
        return (T)parent.findViewById(viewResId);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    protected void toast(@StringRes int resId){
        toast(getString(resId));
    }

    protected void toast(String str){
        Toast.makeText(getApplicationContext(),str,Toast.LENGTH_LONG).show();
    }
}

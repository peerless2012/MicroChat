package com.peerless2012.microchat.splash;

import android.os.Handler;
import android.os.Message;
import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseActivity;
import com.peerless2012.microchat.home.HomeActivity;
import com.peerless2012.microchat.utils.PreferenceUtils;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/5/28 16:49
 * @Version V1.0
 * @Description : 欢迎界面
 */
public class SplashActivity extends BaseActivity{

    private Handler mHandler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            // TODO 判断是否登录和是否已经经过引导界面
//            PreferenceUtils.needShowGuide(spaa)
            HomeActivity.launch(SplashActivity.this);
            finish();
        }
    };

    @Override
    protected int getContentLayout() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        mHandler.sendEmptyMessageDelayed(0,3000);
    }
}

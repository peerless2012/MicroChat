package com.peerless2012.microchat.login;

import android.content.Context;
import android.content.Intent;

import com.peerless2012.microchat.base.BaseActivity;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/5/28 17:12
 * @Version V1.0
 * @Description : 登录
 */
public class LoginActivity extends BaseActivity{
    @Override
    protected int getContentLayout() {
        return 0;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    public static void launch(Context context){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }
}

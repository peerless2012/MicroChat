package com.peerless2012.microchat.guide;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;
import android.widget.ListView;

import com.peerless2012.microchat.base.BaseActivity;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/5/28 16:50
 * @Version V1.0
 * @Description : 向导界面（炫 + 厚度的ui效果）
 */
public class GuideActivity extends BaseActivity{
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
        Intent intent = new Intent(context,GuideActivity.class);
        context.startActivity(intent);
    }
}

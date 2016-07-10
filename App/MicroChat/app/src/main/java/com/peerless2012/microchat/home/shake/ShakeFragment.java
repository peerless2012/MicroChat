package com.peerless2012.microchat.home.shake;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.TextView;

import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseFragment;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/6/1 22:47
 * @Version V1.0
 * @Description :摇一摇
 */
public class ShakeFragment extends BaseFragment{

    @Override
    protected @LayoutRes int getViewLayoutRes() {
        return R.layout.fragment_shake;
    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {

    }

    @Override
    public int getTitle() {
        return R.string.fragment_shake_title;
    }

    @Override
    public int getFragmentTag() {
        return R.string.fragment_shake_tag;
    }
}

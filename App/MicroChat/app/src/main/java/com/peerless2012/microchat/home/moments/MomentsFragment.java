package com.peerless2012.microchat.home.moments;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseFragment;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/6/1 22:52
 * @Version V1.0
 * @Description :动态
 */
public class MomentsFragment extends BaseFragment{

    @Override
    protected int getViewLayoutRes() {
        return R.layout.fragment_moments;
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
        return R.string.fragment_moments_title;
    }

    @Override
    public int getFragmentTag() {
        return R.string.fragment_moments_tag;
    }
}

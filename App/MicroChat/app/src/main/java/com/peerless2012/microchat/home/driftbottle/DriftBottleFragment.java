package com.peerless2012.microchat.home.driftbottle;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseFragment;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/6/1 22:55
 * @Version V1.0
 * @Description :漂流瓶
 */
public class DriftBottleFragment extends BaseFragment{

    @Override
    protected int getViewLayoutRes() {
        return R.layout.fragment_drift_bottle;
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
        return R.string.fragment_drift_bottle_title;
    }

    @Override
    public int getFragmentTag() {
        return R.string.fragment_drift_bottle_tag;
    }
}

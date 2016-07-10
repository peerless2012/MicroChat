package com.peerless2012.microchat.home.nearby;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseFragment;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/6/1 22:44
 * @Version V1.0
 * @Description :附近的人
 */
public class PeopleNearByFragment extends BaseFragment{

    @Override
    protected int getViewLayoutRes() {
        return R.layout.fragment_nearby;
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
        return R.string.fragment_nearby_title;
    }

    @Override
    public int getFragmentTag() {
        return R.string.fragment_nearby_tag;
    }
}

package com.peerless2012.microchat.home.setting;

import android.view.View;

import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseFragment;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/6/1 22:49
 * @Version V1.0
 * @Description :设置
 */
public class SettingFragment extends BaseFragment{

    @Override
    protected int getViewLayoutRes() {
        return R.layout.fragment_setting;
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
        return R.string.fragment_setting_title;
    }

    @Override
    public int getFragmentTag() {
        return R.string.fragment_setting_tag;
    }
}

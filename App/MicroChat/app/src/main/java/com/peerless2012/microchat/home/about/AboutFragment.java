package com.peerless2012.microchat.home.about;

import android.view.View;
import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseFragment;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/6/1 22:44
 * @Version V1.0
 * @Description :关于
 */
public class AboutFragment extends BaseFragment{

    @Override
    protected int getViewLayoutRes() {
        return R.layout.fragment_about;
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
        return R.string.fragment_about_title;
    }

    @Override
    public int getFragmentTag() {
        return R.string.fragment_about_tag;
    }
}

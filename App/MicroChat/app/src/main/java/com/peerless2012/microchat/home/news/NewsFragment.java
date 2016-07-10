package com.peerless2012.microchat.home.news;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseFragment;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/6/1 22:56
 * @Version V1.0
 * @Description :新闻
 */
public class NewsFragment extends BaseFragment{

    @Override
    protected int getViewLayoutRes() {
        return R.layout.fragment_news;
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
        return R.string.fragment_news_title;
    }

    @Override
    public int getFragmentTag() {
        return R.string.fragment_news_title;
    }
}

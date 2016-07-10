package com.peerless2012.microchat.home.conversions;

import android.view.View;
import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseFragment;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/6/1 22:34
 * @Version V1.0
 * @Description :会话列表
 */
public class ConversationsFragment extends BaseFragment{

    @Override
    protected int getViewLayoutRes() {
        return R.layout.fragment_chats_list;
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
        return R.string.fragment_conversions_title;
    }

    @Override
    public int getFragmentTag() {
        return R.string.fragment_conversions_tag;
    }
}

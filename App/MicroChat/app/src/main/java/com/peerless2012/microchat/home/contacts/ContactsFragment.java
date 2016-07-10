package com.peerless2012.microchat.home.contacts;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.TextView;

import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseFragment;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/6/1 22:34
 * @Version V1.0
 * @Description :联系人列表
 */
public class ContactsFragment extends BaseFragment{

    @Override
    protected @LayoutRes int getViewLayoutRes() {
        return R.layout.fragment_contacts;
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
        return R.string.fragment_contacts_title;
    }

    @Override
    public int getFragmentTag() {
        return R.string.fragment_contacts_tag;
    }
}

package com.peerless2012.microchat.base;

import android.os.Bundle;
import android.support.annotation.NonNull;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/7/2 15:42
 * @Version V1.0
 * @Description : mvpFragment的抽象类
 */
public abstract class MVPFragment<V,P extends BasePresenter<V>> extends BaseFragment{

    protected P mPresenter;

    @Override
    protected void onSaveInstance(Bundle savedInstanceState) {
        super.onSaveInstance(savedInstanceState);
        mPresenter = getPresenter();
        mPresenter.attach(getPresenterView());
    }

    public abstract @NonNull V getPresenterView();

    public abstract @NonNull P getPresenter();

    @Override
    public void onDestroy() {
        if (mPresenter != null) mPresenter.detach();
        super.onDestroy();
    }
}

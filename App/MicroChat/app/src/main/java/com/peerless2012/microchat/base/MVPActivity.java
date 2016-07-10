package com.peerless2012.microchat.base;

import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/7/2 15:45
 * @Version V1.0
 * @Description : MVP 的Activity基类
 */
public abstract class MVPActivity<V,P extends BasePresenter<V>> extends BaseActivity{

    protected P mPresenter;

    @CallSuper
    @Override
    protected void onSaveInstance(Bundle savedInstanceState) {
        super.onSaveInstance(savedInstanceState);
        mPresenter = getPresenter();
        mPresenter.attach(getPresenterView());
    }

    public abstract @NonNull V getPresenterView();

    public abstract @NonNull P getPresenter();

    @Override
    protected void onDestroy() {
        if (mPresenter != null) mPresenter.detach();
        super.onDestroy();
    }
}

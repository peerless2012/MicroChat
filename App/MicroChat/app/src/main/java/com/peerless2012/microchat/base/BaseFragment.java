package com.peerless2012.microchat.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
* @Author peerless2012
* @Email peerless2012@126.com
* @DateTime 2016/5/29 16:22
* @Version V1.0
* @Description: Fragment基类
*/
public abstract class BaseFragment extends Fragment {

    private View mRootView;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    final public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                   Bundle savedInstanceState) {
        boolean isNewCreate = mRootView == null;
        if (mRootView == null || !needSaveView()) {
            int layoutRes = getViewLayoutRes(savedInstanceState);
            if (layoutRes > 0) {
                mRootView = inflater.inflate(layoutRes, container, false);
            }else {
                View createView = createView(inflater, container,savedInstanceState);
                if (createView != null) {
                    mRootView = createView;
                }else {
                    throw new IllegalArgumentException("Layout res  and create View can't be null at the same time!");
                }
            }
            initView(mRootView,savedInstanceState);
            initListener(savedInstanceState);
            initData(savedInstanceState);
        }
        if (!isNewCreate && needSaveView()) {
            onNewCreate(savedInstanceState);
        }
        return mRootView;
    }

    /**
     * 获取需要加载的View的布局资源id,
     * @return 资源id。</br>如果id > 0则为有效布局文件的资源id。</br>id <= 0 则需要重写 {@link #createView(LayoutInflater, ViewGroup, Bundle)} 方法。
     */
    @LayoutRes
    protected abstract int getViewLayoutRes(Bundle savedInstanceState);
    /**
     * 创建View
     * @param inflater 布局填充器
     * @param container 父布局
     * @return 填充好的View
     */
    protected View createView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState){return null;};

    /**
     * 初始化View
     * @param rootView 根部局的View
     */
    protected abstract void initView(View rootView,Bundle savedInstanceState) ;

    /**
     * 初始化监听
     */
    protected abstract void initListener(Bundle savedInstanceState);

    /**
     * 初始化数据
     * @param savedInstanceState 传递过来的数据
     */
    protected abstract void initData(Bundle savedInstanceState);

    /**
     * 当 {@link #needSaveView()}返回true的时候，不会调用{@link #createView(LayoutInflater, ViewGroup, Bundle)},而会调用{@link #onNewCreate(Bundle)}
     * 类似 {@link android.app.Activity Activity}中的 {@link android.app.Activity#onNewIntent onNewIntent(Intent intent)}
     * @param savedInstanceState 传递过来的数据
     */
    protected void onNewCreate(Bundle savedInstanceState){};

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    /**
     * 是否保存View
     * 如果保存，只要Fragment不被销毁，当Fragment再次attach到View的时候不会创建新的View
     * 如果不保存，不管Fragment有没有被销毁，重新attach的时候都会重新创建View
     * @return true 如果想保存View的实例对象
     */
    protected boolean needSaveView(){
        return true;
    }
}

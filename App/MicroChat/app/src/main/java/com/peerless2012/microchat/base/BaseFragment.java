package com.peerless2012.microchat.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
* @Author peerless2012
* @Email peerless2012@126.com
* @DateTime 2016/7/2 15:39
* @Version V1.0
* @Description: Fragment基类
*/
public abstract class BaseFragment extends Fragment{

	private View mRootView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}
	
	@Override
	final public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		onSaveInstance(savedInstanceState);
		boolean isNewCreate = mRootView == null;
		if (mRootView == null || !needSaveView()) {
			int layoutRes = getViewLayoutRes();
			if (layoutRes > 0) {
				mRootView = inflater.inflate(layoutRes, container, false);
			}else {
				View createView = createView(inflater, container);
				if (createView != null) {
					mRootView = createView;
				}else {
					throw new IllegalArgumentException("Layout res  and create View can't be null at the same time!");
				}
			}
			initView(mRootView);
			initListener();
			initData();
		}
		if (!isNewCreate && needSaveView()) {
			onNewCreate();
		}
		return mRootView;
	}

	/**
	 * 如果你想获取saveinstance，可以重写此方法
	 * @param savedInstanceState
	 */
	protected void onSaveInstance(Bundle savedInstanceState){
		// do nothing
	}
	
	/**
	 * 获取需要加载的View的布局资源id,
	 * @return 资源id。
	 * </br>
	 * 如果id > 0则为有效布局文件的资源id。
	 * </br>
	 * id <= 0 则需要重写 {@link #createView(LayoutInflater, ViewGroup)} 方法。
	 */
	@LayoutRes
	protected abstract  int getViewLayoutRes();
	/**
	 * 创建View
	 * @param inflater 布局填充器
	 * @param container 父布局
	 * @return 填充好的View
	 */
	protected View createView(LayoutInflater inflater, ViewGroup container){return null;};
	
	/**
	 * 初始化View
	 * @param rootView 根部局的View
	 */
	protected abstract void initView(View rootView) ;
	
	/**
	 * 初始化监听
	 */
	protected abstract void initListener();
	
	/**
	 * 初始化数据
	 */
	protected abstract void initData();
	
	/**
	 * 当 {@link #needSaveView()}返回true的时候，不会调用{@link #createView(LayoutInflater, ViewGroup)},而会调用{@link #onNewCreate()}
	 * 类似 {@link android.app.Activity Activity}中的 {@link android.app.Activity#onNewIntent onNewIntent(Intent intent)}
	 */
	protected void onNewCreate(){};
	
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

	/**
	 * 获取Fragment的标题
	 * @return
	 */
	public abstract @StringRes int getTitle();

	/**
	 * 获取当前Fragment的tag标识
	 * @return
	 */
	public abstract @StringRes int getFragmentTag();

	@SuppressWarnings("unchecked")
	protected <T extends View> T getView(int viewResId) {
		return getView(mRootView,viewResId);
	}
	@SuppressWarnings("unchecked")
	protected <T extends View> T getView(View parent,int viewResId) {
		return (T)parent.findViewById(viewResId);
	}

	protected void toast(@StringRes int resId){
		toast(getString(resId));
	}

	protected void toast(String str){
		Toast.makeText(getActivity().getApplication(),str,Toast.LENGTH_LONG).show();
	}
}

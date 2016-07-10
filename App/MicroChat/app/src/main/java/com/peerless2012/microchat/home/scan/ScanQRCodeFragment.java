package com.peerless2012.microchat.home.scan;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseFragment;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/6/1 22:49
 * @Version V1.0
 * @Description :扫描二维码
 */
public class ScanQRCodeFragment extends BaseFragment{


    @Override
    protected int getViewLayoutRes() {
        return R.layout.fragment_scan_qrcode;
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
        return R.string.fragment_scan_qr_title;
    }

    @Override
    public int getFragmentTag() {
        return R.string.fragment_scan_qr_tag;
    }
}

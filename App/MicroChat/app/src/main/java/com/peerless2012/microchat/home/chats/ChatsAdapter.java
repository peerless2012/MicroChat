package com.peerless2012.microchat.home.chats;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.peerless2012.microchat.R;
import com.peerless2012.microchat.domain.ChatInfo;
import java.util.List;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/7/10 21:49
 * @Version V1.0
 * @Description :
 */
public class ChatsAdapter extends BaseQuickAdapter<ChatInfo> {
    public ChatsAdapter(Context context, List<ChatInfo> data) {
        super(context, R.layout.view_chats_item, data);
    }

    @Override
    protected void convert(BaseViewHolder baseViewHolder, ChatInfo chatInfo) {
    }
}

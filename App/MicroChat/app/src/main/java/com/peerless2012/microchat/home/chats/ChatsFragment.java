package com.peerless2012.microchat.home.chats;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.peerless2012.microchat.R;
import com.peerless2012.microchat.base.BaseFragment;
import com.peerless2012.microchat.domain.ChatInfo;

import java.util.ArrayList;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/6/1 22:26
 * @Version V1.0
 * @Description : 会话界面
 */
public class ChatsFragment extends BaseFragment{

    private ChatsAdapter mChatsAdapter;

    private RecyclerView mChatsView;

    @Override
    protected int getViewLayoutRes() {
        return R.layout.fragment_chats;
    }

    @Override
    protected void initView(View rootView) {
        mChatsView = getView(R.id.chats);
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        ArrayList<ChatInfo> chatInfos = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            ChatInfo chatInfo = new ChatInfo();
            chatInfo.setUserName("name "+ i);
            chatInfo.setDesc("描述内容"+i);
            chatInfo.setUpdateTime("AM 9:"+i);
            chatInfos.add(chatInfo);
        }
        mChatsAdapter = new ChatsAdapter(getContext(),chatInfos);
        mChatsView.setLayoutManager(new LinearLayoutManager(getContext()));
        mChatsView.setHasFixedSize(true);
        mChatsView.setAdapter(mChatsAdapter);
        mChatsView.addItemDecoration(new RecycleViewDivider(
                getContext(), LinearLayoutManager.HORIZONTAL));
    }

    @Override
    public int getTitle() {
        return R.string.fragment_chats_title;
    }

    @Override
    public int getFragmentTag() {
        return R.string.fragment_chats_tag;
    }

}

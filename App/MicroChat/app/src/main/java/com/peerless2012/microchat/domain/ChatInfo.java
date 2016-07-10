package com.peerless2012.microchat.domain;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/7/10 21:46
 * @Version V1.0
 * @Description :
 */
public class ChatInfo {

    private String userName;

    private String desc;

    private String updateTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }
}

package com.peerless2012.microchat.app;

import android.app.Application;
import android.util.Log;

import io.realm.DynamicRealm;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmMigration;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/5/27 14:59
 * @Version V1.0
 * @Description : APP的Application类
 */
public class App extends Application{

    /**
     * 标记为，用来判断初始化操作是否已经执行
     * <p>一般情况下Application只会执行一次，但是如果服务中配置了在另外一个进程中执行的话Application会执行多次<p/>
     */
    private boolean isInited = false;

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    private void init() {
        if (isInited) return;
        initRealm();
        isInited = true;
    }

    /**
     * 初始化Realm的配置信息
     */
    private void initRealm() {
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .name("test.realm")
                .migration(new RealmMigration() {
                    @Override
                    public void migrate(DynamicRealm realm, long oldVersion, long newVersion) {
                        // 版本转换
                    }
                })
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }
}

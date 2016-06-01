package com.peerless2012.microchat;

import android.test.AndroidTestCase;
import android.test.AndroidTestRunner;
import android.test.InstrumentationTestCase;
import android.util.Log;

import java.security.Policy;
import java.util.ArrayList;
import java.util.Collections;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;
import io.realm.annotations.PrimaryKey;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/5/27 10:12
 * @Version V1.0
 * @Description :
 */
public class RealmTest extends AndroidTestCase{

    private static final String TAG = "RealmTest";
    private Realm mRealm;
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(mContext)
                .name("test.realm")
                .build();
        mRealm = Realm.getInstance(realmConfiguration);
    }

    public void testCreate(){
        int offset = 0;
        People people = null;
        ArrayList<People> peoples = new ArrayList<People>(10);
        for (int i = 0; i < 10; i++) {
            people = new People();
            people.setName("名字 ： "+(i + offset));
            people.setAge(i+offset);
            peoples.add(people);
        }
        mRealm.beginTransaction();
        mRealm.copyToRealm(peoples);
        mRealm.commitTransaction();
    }

    public void testGet(){
        RealmResults<People> peoples = mRealm.where(People.class).findAll();
        if (peoples == null) {
            Log.i(TAG, "testGet: People");
        }else {
            for (int i = 0; i < peoples.size(); i++) {
                Log.i(TAG, "testGet: People" + peoples.get(i).toString());
            }
        }
    }

    public void testDelete(){

    }

    public void testUpdate(){

    }

    static class People extends RealmObject{

        @PrimaryKey
        private int id;

        private String name;

        private int age;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        @Override
        public String toString() {
            return "People{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}

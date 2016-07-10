package com.peerless2012.microchat.home;

import java.util.UUID;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.RealmClass;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/5/27 13:31
 * @Version V1.0
 * @Description :
 */
@RealmClass
public class People extends RealmObject {


    private String name;

    private int age;

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
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

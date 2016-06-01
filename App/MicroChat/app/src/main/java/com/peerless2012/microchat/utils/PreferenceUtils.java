package com.peerless2012.microchat.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;

/**
 * @author peerless2012
 * @Email peerless2012@126.com
 * @DateTime 2016/5/28 16:56
 * @Version V1.0
 * @Description : SharedPreferences工具类
 */
public class PreferenceUtils {

    private final static String SP_CONFIG = "config";

    /**
     * 是否需要进入引导页
     * @param context
     * @return true 如果需要进入，false 不进入。
     */
    public static boolean needShowGuide(Context context){
        SharedPreferences preferences = context.getSharedPreferences(SP_CONFIG, Context.MODE_PRIVATE);
        int versionCode = getVersionCode(context);
        int preVersionCode = preferences.getInt("VersionCode", -1);
        return versionCode != preVersionCode;
    }

    /**
     * 设置当前版本已经进入过引导页
     * @param context
     */
    public static void setGuided(Context context){
        SharedPreferences preferences = context.getSharedPreferences(SP_CONFIG, Context.MODE_PRIVATE);
        int versionCode = getVersionCode(context);
        preferences.edit().putInt("VersionCode",versionCode).apply();
    }

    //版本名
    public static String getVersionName(Context context) {
        return getPackageInfo(context).versionName;
    }

    //版本号
    public static int getVersionCode(Context context) {
        return getPackageInfo(context).versionCode;
    }

    /**
     * 获取包信息
     * @param context
     * @return 包信息
     */
    private static PackageInfo getPackageInfo(Context context) {
        PackageInfo pi = null;

        try {
            PackageManager pm = context.getPackageManager();
            pi = pm.getPackageInfo(context.getPackageName(),
                    PackageManager.GET_CONFIGURATIONS);

            return pi;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return pi;
    }
}

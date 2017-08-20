package cn.com.vicent.x5.util;

import android.util.Log;

/**
 * Created by 魏兴 on 2017/8/19.
 */

public class LUtil {
    public static boolean Debug = true;
    private static String TAG = "JsBridge";
    public static void e(String tag){
        if(Debug){
            Log.e(TAG, tag);
        }
    }

    public static void e(String tag, Throwable tr){
        if(Debug){
            Log.e(TAG, tag,tr);
        }
    }
}

package cn.com.vicent.x5;

import android.content.Context;
import android.util.Log;

import com.tencent.smtt.sdk.QbSdk;

/**
 * Created by 魏兴 on 2017/8/20.
 */

public class JsBridge {
    private static QbSdk.PreInitCallback cb = new QbSdk.PreInitCallback() {

        @Override
        public void onViewInitFinished(boolean arg0) {
            // TODO Auto-generated method stub
            Log.e("0912", " onViewInitFinished is " + arg0);
        }

        @Override
        public void onCoreInitFinished() {
            // TODO Auto-generated method stub

        }
    };
    public static void initX5(Context context) {
        //预加载中...
        QbSdk.initX5Environment(context,  cb);

        if (!QbSdk.isTbsCoreInited()) {

            // preinit只需要调用一次，如果已经完成了初始化，那么就直接构造view

            QbSdk.preInit(context, null);// 设置X5初始化完成的回调接口

        }
    }
}

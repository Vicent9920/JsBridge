package cn.com.vicent.x5.jsbridge;

/**
 * Created by 魏兴 on 2017/8/19.
 */

public class JsDefaultHandler implements JsBridgeHandler{
    @Override
    public void handler(String name, String data, CallBackFunction function) {
        if(function != null){
            function.onCallBack("DefaultHandler response data");
        }
    }
}

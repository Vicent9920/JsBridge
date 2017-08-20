package cn.com.vicent.x5;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import cn.com.vicent.x5.util.LUtil;

public class TencentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tencent);
        WebView webView = (WebView) findViewById(R.id.tencent_webView);
        webView.setWebViewClient(new WebViewClient(){
            long time = 0;

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                time = System.currentTimeMillis();
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                time = System.currentTimeMillis()-time;
                LUtil.e("TencentActivity:"+time);
            }
        });
        webView.setWebChromeClient(new WebChromeClient());
        webView.loadUrl("file:///android_asset/demo.html");
        ActionBar bar = getSupportActionBar();
        bar.setTitle("TencentActivity");
        bar.setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this,NativeActivity.class));
                finish();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }
}

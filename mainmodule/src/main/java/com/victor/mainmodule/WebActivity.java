package com.victor.mainmodule;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;

@Route(path = "/web/activity")
public class WebActivity extends AppCompatActivity {

    public static final void launch(){
        ARouter.getInstance().build("/web/activity").navigation();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        final WebView webView = (WebView) findViewById(R.id.web_view);
        webView.loadUrl("file:///android_asset/schame-test.html");

        /*webView.setWebViewClient(new WebViewClient(){
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                Uri url = request.getUrl();
                String urlStr = url.toString();
                if (urlStr.contains("arouter://")) {
                    return true;
                } else {
                    webView.loadUrl(urlStr);
                }
                return true;
            }
        });*/
    }
}

package com.nguyenthanhnam.ungdungdocbao;

import Config.ConfigApp;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import demomap.nguyenthanhnam.com.ungdungdocbao.R;

/**
 * Created by namnguyenthanhnam on 9/2/2016.
 */
public class ReadActivity extends Activity {
    private WebView webView;
    private String url;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read);
        Intent intent=getIntent();
        url=intent.getStringExtra(ConfigApp.KEY_POSITION_LINK);
        findViewBys();
        init(url);
    }

    private void findViewBys() {
        webView = (WebView) findViewById(R.id.webview);
        webView.setWebViewClient(new MyBrowser());
    }

    private void init(String url) {

        webView.getSettings().setLoadsImagesAutomatically(true);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webView.loadUrl(url);
    }

    private void setEvent() {

    }
    private class MyBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}

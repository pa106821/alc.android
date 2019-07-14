package com.example.alc40phase1challengeandroid;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);

        WebView webb =(WebView) findViewById(R.id.mywebview);
        webb.setWebViewClient(new webBrowser());
        webb.getSettings().setJavaScriptEnabled(true);
        webb.getSettings().setBuiltInZoomControls(true);
        webb.getSettings().setSupportZoom(true);
        webb.loadUrl("https://andela.com/alc");

    }
    private class webBrowser extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return  true;
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            switch (error.getPrimaryError()){
                case SslError.SSL_UNTRUSTED:
                    Log.d("SslUntrusted","certificate is not secure");
                    break;
            }
            handler.proceed();
        }
    }

    }

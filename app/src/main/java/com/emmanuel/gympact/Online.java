package com.emmanuel.gympact;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by user on 07/04/2016.
 */
public class Online extends Fragment {

    View myView;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.online, container, false); // we are instantiating the myView object with the method inside of the inflater object with the first parameter of the inflator.inflate method being r.layout.my_workouts
        WebView webView = (WebView) myView.findViewById(R.id.myWebView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.google.co.uk/webhp?hl=en");
        webSettings.setBuiltInZoomControls(true);
        webView.setInitialScale(100);
        webView.setWebViewClient(new WebViewClient());

        return myView;

    }
}
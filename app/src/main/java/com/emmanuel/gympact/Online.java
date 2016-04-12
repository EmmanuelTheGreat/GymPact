package com.emmanuel.gympact;

import android.app.Fragment;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

/**
 * Created by user on 07/04/2016.
 */
public class Online extends Fragment {

    View FragmentView;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FragmentView = inflater.inflate(R.layout.online, container, false); // we are instantiating the FragmentView object with the method inside of the inflater object with the first parameter of the inflator.inflate method being r.layout.my_workouts

        WebView webView = (WebView) FragmentView.findViewById(R.id.myWebView);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        // webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl("https://www.google.co.uk/webhp?hl=en");
        webSettings.setBuiltInZoomControls(true);
        webView.setInitialScale(180);
        webView.setWebViewClient(new myWebClient());

        return FragmentView;

    }

    private class myWebClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            if(Uri.parse(url).getHost().equals("www.google.co.uk")){
                //open webpage in webview
                return false;
            }
            else{
                //otherwise open website in external browser/app
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
                return true;
            }
        }

        //progress dialog

        ProgressDialog pd = null;

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {

            pd = new ProgressDialog(Online.this.getActivity());
            pd.setTitle("Just a moment");
            pd.setMessage("You're almost there... :)");
            pd.show();
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            pd.dismiss();
            super.onPageFinished(view, url);
        }
    }





}
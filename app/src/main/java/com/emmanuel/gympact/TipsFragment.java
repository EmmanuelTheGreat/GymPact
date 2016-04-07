package com.emmanuel.gympact;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Created by user on 07/04/2016.
 */
public class TipsFragment extends Fragment {

    View myView;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.tips_fragment, container, false); // we are instantiating the myView object with the method inside of the inflater object with the first parameter of the inflator.inflate method being r.layout.my_workouts
        return myView;

    }
}
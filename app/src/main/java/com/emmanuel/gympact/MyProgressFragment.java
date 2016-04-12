package com.emmanuel.gympact;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 09/04/2016.
 */
public class MyProgressFragment extends PreferenceFragment{

    View FragmentView;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentView = inflater.inflate(R.layout.myprogress, container, false); // we are instantiating the FragmentView object with the method inside of the inflater object with the first parameter of the inflator.inflate method being r.layout.my_workouts
        return FragmentView;

    }
}

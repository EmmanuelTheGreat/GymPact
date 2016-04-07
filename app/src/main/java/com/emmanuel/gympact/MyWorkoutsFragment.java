package com.emmanuel.gympact;

import android.app.Fragment;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 07/04/2016.
 */
public class MyWorkoutsFragment extends PreferenceFragment {

        View myView;

        @Nullable
        @Override

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.my_workouts, container, false); // we are instantiating the myView object with the method inside of the inflater object with the first parameter of the inflator.inflate method being r.layout.my_workouts
        return myView;

    }
    }




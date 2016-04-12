package com.emmanuel.gympact;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by user on 11/04/2016.
 */
public class Settings extends Fragment {

    View FragmentView;

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        FragmentView = inflater.inflate(R.layout.settings, container, false); // we are instantiating the FragmentView object with the method inside of the inflater object with the first parameter of the inflator.inflate method being r.layout.my_workouts

        return FragmentView;

    }

}

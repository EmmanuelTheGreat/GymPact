package com.emmanuel.gympact;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by user on 07/04/2016.
 */
public class MyWorkoutsFragment extends PreferenceFragment{

        View myView;

        @Nullable
        @Override

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.my_workouts, container, false); // we are instantiating the myView object with the method inside of the inflater object with the first parameter of the inflator.inflate method being r.layout.my_workouts

            final Button chestButton =(Button)myView.findViewById(R.id.ChestBtn);
            final Button backButton =(Button)myView.findViewById(R.id.BackBtn);
            final Button legsButton =(Button)myView.findViewById(R.id.LegBtn);

            chestButton.setOnClickListener(new View.OnClickListener(){
            
                @Override
                public void onClick(View v) {
                    Intent ChestIntent = new Intent(getActivity(), Chest.class);
                    startActivity(ChestIntent);

                }
            });

         /*   backButton.setOnClickListener(){

            };

            legsButton.setOnClickListener(){

            };

            */
            return myView;

    }
    }




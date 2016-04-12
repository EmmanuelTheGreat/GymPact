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

        View FragmentView;

        @Nullable
        @Override

        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            FragmentView = inflater.inflate(R.layout.my_workouts, container, false); // we are instantiating the FragmentView object with the method inside of the inflater object with the first parameter of the inflator.inflate method being r.layout.my_workouts

            final Button chestButton =(Button)FragmentView.findViewById(R.id.ChestBtn);
            final Button backButton =(Button)FragmentView.findViewById(R.id.BackBtn);
            final Button legsButton =(Button)FragmentView.findViewById(R.id.LegBtn);

            //CHEST Exercise Button
            chestButton.setOnClickListener(new View.OnClickListener(){
            
                @Override
                public void onClick(View v) {
                    Intent ChestIntent = new Intent(getActivity(), ChestExercise.class);
                    startActivity(ChestIntent);

                }
            });


            //BACK Exercise Button
            backButton.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent BackIntent = new Intent(getActivity(), BackExercise.class);
                    startActivity(BackIntent);

                }
            });

            //LEGS Exercise Button

            legsButton.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Intent LegsIntent = new Intent(getActivity(), LegsExercise.class);
                    startActivity(LegsIntent);

                }
            });



         /*   backButton.setOnClickListener(){

            };

            legsButton.setOnClickListener(){

            };

            */
            return FragmentView;

    }
    }




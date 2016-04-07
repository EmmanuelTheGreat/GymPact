package com.emmanuel.gympact;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by user on 07/04/2016.
 */
public class Bmi_calc extends Fragment {

    View myView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        myView = inflater.inflate(R.layout.bmi_calc, container, false); // we are instantiating the myView object with the method inside of the inflater object with the first parameter of the inflator.inflate method being r.layout.about_me
        // return myView;



        //    View rootView = inflater.inflate(R.layout., container, false);

        // }

        //public void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //setContentView(R.layout.about_me);


        final Button BMICalc = (Button)myView.findViewById(R.id.calculatebmi);
        final EditText field_weight = (EditText)myView.findViewById(R.id.field_weight);
        final EditText field_height = (EditText)myView.findViewById(R.id.field_height);
        final TextView view_result = (TextView)myView.findViewById(R.id.view_result);
        final TextView view_msg = (TextView)
                myView.findViewById(R.id.view_msg);

        BMICalc.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View v){

                double weight;
                double height;
                double bmi;
                String msg= "";

                weight = Double.parseDouble(field_weight.getText().toString());
                height = Double.parseDouble(field_height.getText().toString());

                //    if(field_height.getText().toString().equals("")|| field_weight.getText().toString().equals("")){

                //   Toast.makeText(getContext(), "No valid values" , Toast.LENGTH_LONG);

                //  Toast.makeText(getApplicationContext(), "No valid values" , Toast.LENGTH_LONG);
                // }

                bmi = height*height;
                bmi = weight/ bmi;

                view_result.setText(String.valueOf(bmi));
                if(bmi < 18.5){

                    msg = "You are Underweight. Why not try to put some on. Lets head over to the My Workouts section :)" ;
                }else if (bmi > 18.5 && bmi < 25){

                    msg = "Well done your weight is normal :)";
                }else if (bmi > 25) {

                    msg = "Looks like your weight could be a little lower. Why don't we head over to the My Workouts section :)";
                }

                view_msg.setText(msg);


            }
        });
        return myView;
    }

}

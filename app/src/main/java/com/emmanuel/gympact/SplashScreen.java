package com.emmanuel.gympact;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        //Thread object
        Thread transition = new Thread() {

            @Override
            public void run() {
                try {
                    sleep(2000); // sleep for 3000 milli seconds = how long the splash screen will be displayed before transitioning to the main screen
                    Intent StartMainScreen = new Intent(getApplicationContext(), LoginActivity.class); // Intent = intend to start a new activity. In this case main activity.
                    startActivity(StartMainScreen); // here the system is starting the Intended activity "StartMainScreen".
                    finish(); // this will finish the current activity "SplashScreen"
                } catch (InterruptedException e) {

                    e.printStackTrace(); // Try- Catch method above surrounds the "sleep" statement in case there is an error.


                }
            }

        };
        // below will start the thread we have just created above
        transition.start();
    }
}
package com.emmanuel.gympact;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class UserAreaActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_area);


        final EditText etUsername = (EditText)findViewById(R.id.etUsername);
        final EditText etAge = (EditText)findViewById(R.id.etAge);
        final TextView welcomeMessage = (TextView)findViewById(R.id.tvWelcomeMsg);
        //final Button navButton = (Button)findViewById(R.id.navButton);
       /* navButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent menuIntent = new Intent(UserAreaActivity.this, MainActivity.class);
                startActivity(menuIntent);

            }
        });
*/
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.navButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent menuIntent = new Intent(UserAreaActivity.this, MainActivity.class);
                startActivity(menuIntent);

            }
        });



        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String username = intent.getStringExtra("username");
        int age = intent.getIntExtra("age", -1);

        String message = name + " welcome to your general hubpoint :)";
        welcomeMessage.setText(message);
        etUsername.setText(username);
        etAge.setText(age + "");
    }

}

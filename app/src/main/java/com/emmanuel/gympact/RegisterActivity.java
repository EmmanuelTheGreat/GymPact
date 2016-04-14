package com.emmanuel.gympact;

import android.app.AlertDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final EditText etName = (EditText)findViewById(R.id.etName);
        final EditText etAge = (EditText)findViewById(R.id.etAge);
        final EditText etUsername = (EditText)findViewById(R.id.etUsername);
        final EditText etPassword = (EditText)findViewById(R.id.etPassword);

        final Button bRegister =(Button)findViewById(R.id.bRegister);
        final TextView loginLink = (TextView)findViewById(R.id.tvLogin);


        final String ageLength = etAge.getText().toString().trim();


        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                RegisterActivity.this.startActivity(loginIntent);
            }
        });


        bRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String name = etName.getText().toString();
                final String username = etUsername.getText().toString();
                final String password = etPassword.getText().toString();
                final int age = Integer.parseInt(etAge.getText().toString());

                final boolean[] cancel = {false};
                final View[] focusView = {null};

                Response.Listener<String> responseListener = new Response.Listener<String>(){


                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);

                            boolean success = jsonResponse.getBoolean("success");

                            if(etName.length() < 1){

                                etName.setError("Name required");
                                focusView[0] = etName;
                                cancel[0] = true;


                                Toast.makeText(RegisterActivity.this, "Please enter your name",
                                        Toast.LENGTH_SHORT).show();

                            }else if(etUsername.length() < 1) {

                                etUsername.setError("Username required");
                                focusView[0] = etUsername;
                                cancel[0] = true;

                                Toast.makeText(RegisterActivity.this, "Please enter your username",
                                        Toast.LENGTH_SHORT).show();

                            }    else if(etPassword.length() < 5){

                                etPassword.setError("Minimum of 5 characters required");
                                focusView[0] = etPassword;
                                cancel[0] = true;

                                    Toast.makeText(RegisterActivity.this, "Password is required to be at least 5 characters",
                                            Toast.LENGTH_SHORT).show();
                            }else if(etAge.getText().toString().trim().length() < 0/*(ageLength.length() == 0 || ageLength.equals(""))*/){

                                etAge.setError("Age required");
                                focusView[0] = etAge;
                                cancel[0] = true;

                                Toast.makeText(RegisterActivity.this, "Please enter your age",
                                        Toast.LENGTH_SHORT).show();
                            }else if(success){
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);
                            }else {

                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Username is already taken")
                                        .setNegativeButton("Retry", null).create().show();
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(name,username,age,password,responseListener);
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(registerRequest);



            }
        });
    }
}

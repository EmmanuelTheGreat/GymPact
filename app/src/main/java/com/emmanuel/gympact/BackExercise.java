package com.emmanuel.gympact;

import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BackExercise extends AppCompatActivity{

    DatabaseHelperBack myDatabase;

    EditText etdate;
    EditText exercise;
    EditText weight;
    EditText reps;

    Button addData;
    Button viewStats;
    Button EditUpdate;
    Button Delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_back_exercise);
        getSupportActionBar().setTitle("Back");

        myDatabase = new DatabaseHelperBack(this);

        etdate = (EditText) findViewById(R.id.date);
        exercise = (EditText) findViewById(R.id.etExercise);
        weight = (EditText) findViewById(R.id.etWeight);
        reps = (EditText) findViewById(R.id.etReps);
        addData = (Button) findViewById(R.id.addBtn);
        viewStats = (Button) findViewById(R.id.viewBtn);
        EditUpdate =(Button) findViewById(R.id.editBtn);
        Delete =(Button) findViewById(R.id.deleteBtn);
        addData();
        ViewStats();
        EditUpdateData();
        deleteData();


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    public void addData() {

        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isDataInserted =  myDatabase.insertData(
                        exercise.getText().toString(),
                        weight.getText().toString(),
                        reps.getText().toString());

                final boolean[] cancel = {false};
                final View[] focusView = {null};

                 if(exercise.length() < 1) {

                    // final boolean[] cancel = {false};
                     //final View[] focusView = {null};

                     exercise.setError("You must fill in this field");
                     focusView[0] = exercise;
                     cancel[0] = true;

                     Toast.makeText(BackExercise.this, "Enter exercise",
                             Toast.LENGTH_SHORT).show();

                 } else if (weight.length() < 1) {

                     // final boolean[] cancel = {false};
                     //final View[] focusView = {null};

                     weight.setError("You must fill in this field");
                     focusView[0] = weight;
                     cancel[0] = true;

                     Toast.makeText(BackExercise.this, "Enter weight",
                             Toast.LENGTH_SHORT).show();

                 } else if (reps.length() < 1) {

                     // final boolean[] cancel = {false};
                     //final View[] focusView = {null};

                     reps.setError("You must fill in this field");
                     focusView[0] = reps;
                     cancel[0] = true;

                     Toast.makeText(BackExercise.this, "Enter number of repetitions",
                             Toast.LENGTH_SHORT).show();

                 }else if(isDataInserted == true)
                    Toast.makeText(BackExercise.this, "Data saved successfully", Toast.LENGTH_LONG).show();

                else

                    Toast.makeText(BackExercise.this, "Data insert unsuccessful", Toast.LENGTH_LONG).show();
            }
        });
    }

    public void ViewStats(){
        viewStats.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             Cursor result = myDatabase.retrieveData();

                                             if(result.getCount()== 0){
                                                 //display message
                                                 DisplayMessage("This is awkward", "No data found");

                                                 return;
                                             }
                                             //create an instance of a string buffer
                                             StringBuffer buffer = new StringBuffer();

                                             while(result.moveToNext()) {
                                                 //store result into buffer
                                                 buffer.append("date :" + result.getString(0) + "\n");
                                                 buffer.append("exercise :" + result.getString(1) + "\n");
                                                 buffer.append("weight :" + result.getString(2) + "\n");
                                                 buffer.append("reps :" + result.getString(3) + "\n\n");
                                             }

                                             //display all data
                                             DisplayMessage("Back Data", buffer.toString());
                                         }
                                     }
        );

    }

    public void EditUpdateData(){
        EditUpdate.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              boolean isDataUpdated = myDatabase.EditUpdateData(etdate.getText().toString(), exercise.getText().toString(), weight.getText().toString(), reps.getText().toString());

                                              if(isDataUpdated == true)
                                                  Toast.makeText(BackExercise.this, "Update Successful :)", Toast.LENGTH_LONG).show();

                                              else

                                                  Toast.makeText(BackExercise.this, "Update Unsuccessful :( ", Toast.LENGTH_LONG).show();
                                          }
                                      }
        );

    }

    public void deleteData(){
        Delete.setOnClickListener(new View.OnClickListener() {
                                      @Override
                                      public void onClick(View v) {
                                          Integer rowsDeleted = myDatabase.delete(etdate.getText().toString());

                                          if(rowsDeleted > 0)
                                              Toast.makeText(BackExercise.this, "Deleted", Toast.LENGTH_LONG).show();

                                          else

                                              Toast.makeText(BackExercise.this, "Error data does not exist", Toast.LENGTH_LONG).show();

                                      }
                                  }
        );

    }


    public void DisplayMessage(String title,String Message){

        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }
}


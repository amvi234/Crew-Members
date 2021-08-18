package com.example.internassign.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.internassign.MainActivity;
import com.example.internassign.R;
import com.example.internassign.room.DataBaseClient;
import com.example.internassign.room.Task;

import java.nio.channels.AsynchronousChannelGroup;

public class addTaskActivity extends AppCompatActivity {
    private EditText etName, etAgency, etImage, etWikipedia, etLaunches, etStatus;
    private Button btSubmit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        setId();
        setOnClick();
    }

    private void setOnClick() {
        btSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validation()){
                    new saveTask().execute();
                }
            }
        });
    }
    private void setId() {
        etName = findViewById(R.id.etName);
        etAgency = findViewById(R.id.etAgency);
        etImage= findViewById(R.id.etImage);
        etWikipedia= findViewById(R.id.etWikipedia);
        etLaunches= findViewById(R.id.etLaunches);
        etStatus= findViewById(R.id.etStatus);
        btSubmit = findViewById(R.id.btSubmit);

    }

    private boolean validation() {
        if(etName.getText().toString().trim().isEmpty()){
            etName.setError("Please Enter ur Name");
            etName.requestFocus();
            return false;
        }
        else if(etAgency.getText().toString().trim().isEmpty()){
            etAgency.setError("Please Enter Agency");
            etAgency.requestFocus();
            return false;
        }
        else if(etImage.getText().toString().trim().isEmpty()){
            etImage.setError("Please Enter Image");
            etImage.requestFocus();
            return false;}
            else if(etWikipedia.getText().toString().trim().isEmpty()){
                    etImage.setError("Please Enter Wikipedia");
                    etImage.requestFocus();
                    return false;}
        else if(etWikipedia.getText().toString().trim().isEmpty()){
                    etImage.setError("Please Enter Wikipedia");
                    etImage.requestFocus();
                    return false;

        }
        else if(etLaunches.getText().toString().trim().isEmpty()){
            etLaunches.setError("Please Enter Launches");
            etLaunches.requestFocus();
            return false;}
        else if(etStatus.getText().toString().trim().isEmpty()){
            etStatus.setError("Please Enter Status");
            etStatus.requestFocus();
            return false;}

        else{
            return true;
        }

    }
    class saveTask extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... voids) {


            new Handler(Looper.getMainLooper()){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    btSubmit.setText("Please Wait . . .");
                    btSubmit.setEnabled(false);
                }
            };
            Task task= new Task();
            task.setName(etName.getText().toString().trim());
            task.setAgency(etAgency.getText().toString().trim());
            task.setImage(etImage.getText().toString().trim());
            task.setWikipedia(etWikipedia.getText().toString().trim());
            task.setLaunches(etLaunches.getText().toString().trim());
            task.setStatus(etStatus.getText().toString().trim());


            //add to database
            DataBaseClient.getInstance(getApplicationContext()).getAppDataBase().taskdao().insert(task);
;
            return null;
        }

        @Override
        protected void onPostExecute(Void unused) {
            super.onPostExecute(unused);
            new Handler(Looper.getMainLooper()){
                @Override
                public void handleMessage(@NonNull Message msg) {
                    super.handleMessage(msg);
                    btSubmit.setText("submit");
                    btSubmit.setEnabled(true);
                }
            };
            Toast.makeText(getApplicationContext(), "Successfully Saved" , Toast.LENGTH_LONG).show();
            startActivity(new Intent(getApplicationContext() , MainActivity.class));
            finish();
        }
    }


}
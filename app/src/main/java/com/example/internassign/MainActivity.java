package com.example.internassign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.internassign.activity.addTaskActivity;
import com.example.internassign.adapter.TaskAdapter;
import com.example.internassign.room.DataBaseClient;
import com.example.internassign.room.Task;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ImageView add;
    private RecyclerView rvTask;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.add);
        rvTask = findViewById(R.id.rvTask);


        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, addTaskActivity.class));
            }
        });
        new getTask().execute();
    }
    class getTask extends AsyncTask<Void , Void, List<Task>>{

        @Override
        protected List<Task> doInBackground(Void... voids) {
            List<Task> taskList = DataBaseClient.getInstance(getApplicationContext()).getAppDataBase().taskdao().getAllData();
            return taskList;
        }

        @Override
        protected void onPostExecute(List<Task> tasks) {
            super.onPostExecute(tasks);
//            Log.e("TaskDetails: ", tasks.get(tasks.size()-1).getName());
            TaskAdapter adapter = new TaskAdapter(MainActivity.this, tasks  );
            rvTask.setAdapter(adapter);
        }
    }
}
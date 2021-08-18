package com.example.internassign.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.internassign.MainActivity;
import com.example.internassign.R;
import com.example.internassign.room.Task;

import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter<TaskAdapter.MyViewHolder> {




    private Context mContext;
    private List<Task> tasks;



    public TaskAdapter(MainActivity mainActivity, List<Task> tasks ) {
        this.mContext = mainActivity;
        this.tasks = tasks;

    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View  view = LayoutInflater.from(mContext).inflate(R.layout.view_task, parent ,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder (@NonNull MyViewHolder holder, int position) {
        holder.tvName.setText(tasks.get(position).getName());
        holder.tvAgency.setText(tasks.get(position).getAgency());
        holder.tvImage.setText(tasks.get(position).getImage());
        holder.tvWikipedia.setText(tasks.get(position).getWikipedia());
        holder.tvLaunches.setText(tasks.get(position).getLaunches());
        holder.tvStatus.setText(tasks.get(position).getStatus());
        holder.tvId.setText(tasks.get(position).getId());

    }

    @Override
    public int getItemCount() {
        return tasks.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder  {
        private TextView tvName, tvAgency, tvImage, tvWikipedia, tvLaunches, tvStatus, tvId ;
        private ImageView tvdelete;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvAgency = itemView.findViewById(R.id.tvAgency);
            tvImage = itemView.findViewById(R.id.tvImage);
            tvWikipedia = itemView.findViewById(R.id.tvWikipedia);
            tvLaunches = itemView.findViewById(R.id.tvLaunches);
            tvStatus = itemView.findViewById(R.id.tvStatus);
            tvId = itemView.findViewById(R.id.tvId);
            tvdelete = itemView.findViewById(R.id.tvdelete);

        }





    }

}

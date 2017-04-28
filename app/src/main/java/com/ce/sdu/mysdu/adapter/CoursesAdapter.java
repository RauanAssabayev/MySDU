package com.ce.sdu.mysdu.adapter;

/**
 * Created by rauan on 07.04.2017.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.ce.sdu.mysdu.R;
import java.util.ArrayList;

import com.ce.sdu.mysdu.model.DataModel;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.MyViewHolder> {

    private ArrayList<DataModel> dataSet;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewVersion;
        TextView textViewTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.course_title);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.course_grade);
            this.textViewTime = (TextView) itemView.findViewById(R.id.time);
        }
    }
    public CoursesAdapter(ArrayList<DataModel> dataModels) {
        this.dataSet = dataModels;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                          .inflate(R.layout.course_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        TextView textViewTime =  holder.textViewTime;
        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getVersion());
        textViewTime.setText(dataSet.get(listPosition).getId());
    }
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}


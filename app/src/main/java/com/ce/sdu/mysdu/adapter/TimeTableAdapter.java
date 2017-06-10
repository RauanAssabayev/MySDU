package com.ce.sdu.mysdu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ce.sdu.mysdu.R;
import com.ce.sdu.mysdu.model.Courses;
import com.ce.sdu.mysdu.model.RegCourses;

import java.util.ArrayList;

/**
 * Created by rauan on 08.06.2017.
 */

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.MyViewHolder> {
    private ArrayList<RegCourses> dataSet;
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvsubject;
        TextView tvTeacher;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tvsubject = (TextView) itemView.findViewById(R.id.course_title);
            this.tvTeacher = (TextView) itemView.findViewById(R.id.course_teacher);
        }
    }
    public TimeTableAdapter(ArrayList<RegCourses> dataModels) {
        this.dataSet = dataModels;
    }
    @Override

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        TextView tvsubject = holder.tvsubject;
        TextView tvTeacher = holder.tvTeacher;
        tvsubject.setText(dataSet.get(listPosition).getDersTitle()+"");
        tvTeacher.setText(dataSet.get(listPosition).getnEmpTitle()+"");
    }
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
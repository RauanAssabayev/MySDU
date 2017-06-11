package com.ce.sdu.mysdu.adapter;
/**
 * Created by rauan on 07.04.2017.
 */
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ce.sdu.mysdu.R;
import java.util.ArrayList;

import com.ce.sdu.mysdu.model.Courses;
import com.ce.sdu.mysdu.model.DataModel;

public class CoursesAdapter extends RecyclerView.Adapter<CoursesAdapter.MyViewHolder> {
    private ArrayList<Courses> dataSet;
    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvsubject;
        TextView tvmd1;
        TextView tvmd2;
        TextView tvfin;
        TextView tvavg;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.tvsubject = (TextView) itemView.findViewById(R.id.tvsubject);
            this.tvmd1 = (TextView) itemView.findViewById(R.id.tvmd1);
            this.tvmd2 = (TextView) itemView.findViewById(R.id.tvmd2);
            this.tvfin = (TextView) itemView.findViewById(R.id.tvfin);
            this.tvavg = (TextView) itemView.findViewById(R.id.tvavg);
        }
    }
    public CoursesAdapter(ArrayList<Courses> dataModels) {
        this.dataSet = dataModels;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grade_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }
    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {
        TextView tvsubject = holder.tvsubject;
        TextView tvmd1 = holder.tvmd1;
        TextView tvmd2 = holder.tvmd2;
        TextView tvfin = holder.tvfin;
        TextView tvavg = holder.tvavg;
        tvsubject.setText(dataSet.get(listPosition).getTitle()+"");
        tvmd1.setText(dataSet.get(listPosition).getMt1()+"");
        tvmd2.setText(dataSet.get(listPosition).getMt2()+"");
        tvfin.setText(dataSet.get(listPosition).getFin()+"");
        tvavg.setText(dataSet.get(listPosition).getOrt()+"");
        int avg = dataSet.get(listPosition).getOrt();
        if(avg>=75){
            tvavg.setTextColor(Color.GREEN);
        }
        else if(avg >= 50 && avg < 75){
            tvavg.setTextColor(Color.rgb(255, 153, 0));

        }else {
            tvavg.setTextColor(Color.RED);
        }
    }
    @Override
    public int getItemCount() {
        return dataSet.size();
    }


}
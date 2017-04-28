package com.ce.sdu.mysdu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ce.sdu.mysdu.R;
import com.ce.sdu.mysdu.model.DataModel;
import com.ce.sdu.mysdu.model.GradesModel;

import java.util.ArrayList;

/**
 * Created by rauan on 14.04.2017.
 */

public class GradesAdapter extends RecyclerView.Adapter<GradesAdapter.MyViewHolder>{
    private ArrayList<GradesModel> dataSet;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName;
        TextView textViewVersion;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
        }
    }
    public GradesAdapter(ArrayList<GradesModel> dataModels) {
        this.dataSet = dataModels;
    }
    @Override
    public GradesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.courses_layout, parent, false);
        GradesAdapter.MyViewHolder myViewHolder = new GradesAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final GradesAdapter.MyViewHolder holder, final int listPosition) {
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getVersion());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

}

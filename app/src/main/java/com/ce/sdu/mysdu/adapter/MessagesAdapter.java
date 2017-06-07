package com.ce.sdu.mysdu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ce.sdu.mysdu.R;
import com.ce.sdu.mysdu.model.Message;
import java.util.ArrayList;

/**
 * Created by rauan on 06.06.2017.
 */

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MyViewHolder> {
    private ArrayList<Message> dataSet;
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
    public MessagesAdapter(ArrayList<Message> dataModels) {
        this.dataSet = dataModels;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.course_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        TextView textViewTime =  holder.textViewTime;
        textViewName.setText(dataSet.get(position).getMsgId());
        textViewVersion.setText(dataSet.get(position).getSubject());
        textViewTime.setText(dataSet.get(position).getMsgId());
    }
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
package com.ce.sdu.mysdu.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.ce.sdu.mysdu.R;
import com.ce.sdu.mysdu.model.Message;
import java.util.ArrayList;

public class MessagesAdapter extends RecyclerView.Adapter<MessagesAdapter.MyViewHolder> {
    private ArrayList<Message> dataSet;
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView sender;
        TextView subject;
        TextView sentdate;
        public MyViewHolder(View itemView) {
            super(itemView);
            this.sender = (TextView) itemView.findViewById(R.id.sender);
            this.subject = (TextView) itemView.findViewById(R.id.subject);
            this.sentdate = (TextView) itemView.findViewById(R.id.sentdate);
        }
    }
    public MessagesAdapter(ArrayList<Message> dataModels) {
        this.dataSet = dataModels;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.message_item, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        TextView sender = holder.sender;
        TextView subject = holder.subject;
        TextView sentdate =  holder.sentdate;
        sender.setText(dataSet.get(position).getTeacher());
        subject.setText(dataSet.get(position).getSubject());
        sentdate.setText(dataSet.get(position).getSentDate());
    }
    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}
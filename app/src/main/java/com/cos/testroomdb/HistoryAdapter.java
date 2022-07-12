package com.cos.testroomdb;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {


    private List<History> historyList;

    public HistoryAdapter(List<History> list){
        historyList = list;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.item_history, parent, false);
        HistoryAdapter.ViewHolder viewHolder = new HistoryAdapter.ViewHolder(view);

        return viewHolder;

    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.expression.setText(historyList.get(position).expression);
        holder.result.setText(historyList.get(position).result);

    }


    @Override
    public int getItemCount() {
        return this.historyList.size();
    }


    public void setHistoryList(List<History> historyList){

        this.historyList = historyList;

    }


    class ViewHolder extends RecyclerView.ViewHolder{ //아무것도 없으면 default => 동일한 패키지 내에서 저근가능

        TextView expression, result;

        public ViewHolder(View itemView) {
            super(itemView);

            expression = itemView.findViewById(R.id.textView);
            result = itemView.findViewById(R.id.textView2);


        }
    }

}

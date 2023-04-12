package com.example.sqlitetest;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FimAdapter extends RecyclerView.Adapter<FimAdapter.FimListView> {

    private List<Fim> mfimlist;

    public void setData(List<Fim> list){
        this.mfimlist=list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public FimListView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.movie_category,parent, false);
        return new FimListView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FimListView holder, int position) {
        Fim fim = mfimlist.get(position);
        if(fim == null){
            return;
        }
        holder.tvMa.setText(fim.getMa());
        holder.tvTen.setText(fim.getTen());
    }

    @Override
    public int getItemCount() {
        if(mfimlist!=null){
            return mfimlist.size();
        }
        return 0;
    }

    public class FimListView extends RecyclerView.ViewHolder{

        private TextView tvMa;
        private TextView tvTen;

        public FimListView(@NonNull View itemView) {
            super(itemView);
            tvMa = itemView.findViewById(R.id.tvMa);
            tvTen = itemView.findViewById(R.id.tvTen);
        }
    }
}

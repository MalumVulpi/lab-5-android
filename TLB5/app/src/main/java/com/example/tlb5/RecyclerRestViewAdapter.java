package com.example.tlb5;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerRestViewAdapter extends RecyclerView.Adapter<RecyclerRestViewAdapter.MyViewHolder>{
    static Context mContext;
    List<Rest> mData;

    public RecyclerRestViewAdapter(Context mContext, List<Rest> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_gallery, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.imageView.setImageResource(mData.get(position).getImageResource());
        holder.titleTextView.setText(mData.get(position).getTitle());
        holder.titleStreet.setText(mData.get(position).getStreet());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private ImageView imageView;
        private TextView titleTextView;
        private TextView titleStreet;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            titleTextView = itemView.findViewById(R.id.restTextView);
            titleStreet = itemView.findViewById(R.id.restStreetTextView);
            imageView = itemView.findViewById(R.id.restImageView);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Rest items = mData.get(position);

            Intent intent = new Intent(mContext, DetailGalleryActivity.class);
            intent.putExtra("image", items.getImageResource());
            intent.putExtra("title", items.getTitle());
            intent.putExtra("street", items.getStreet());
            intent.putExtra("time", items.getTime());
            intent.putExtra("reit", items.getReit());
            mContext.startActivity(intent);
        }
    }
}

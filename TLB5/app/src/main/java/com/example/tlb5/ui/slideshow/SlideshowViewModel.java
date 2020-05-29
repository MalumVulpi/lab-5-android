package com.example.tlb5.ui.slideshow;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tlb5.DetailSlideActivity;
import com.example.tlb5.Museum;
import com.example.tlb5.R;
import com.example.tlb5.RecyclerMuseumViewAdapter;

import java.util.List;

public class SlideshowViewModel extends RecyclerView.Adapter<SlideshowViewModel.MyViewHolder> {
    static Context mContext;
    List<Museum> mData;

    public SlideshowViewModel(Context mContext, List<Museum> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }


    @NonNull
    @Override
    public SlideshowViewModel.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_slideshow, parent, false);
        SlideshowViewModel.MyViewHolder viewHolder = new SlideshowViewModel.MyViewHolder(v);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SlideshowViewModel.MyViewHolder holder, int position) {
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

            titleTextView = itemView.findViewById(R.id.slideTextView);
            titleStreet = itemView.findViewById(R.id.slideStreetTextView);
            imageView = itemView.findViewById(R.id.slideImageView);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Museum items = mData.get(position);

            Intent intent = new Intent(mContext, DetailSlideActivity.class);
            intent.putExtra("image", items.getImageResource());
            intent.putExtra("title", items.getTitle());
            intent.putExtra("street", items.getStreet());
            intent.putExtra("time", items.getTime());
            intent.putExtra("reit", items.getReit());
            mContext.startActivity(intent);
        }
        }
}
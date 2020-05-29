package com.example.tlb5.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tlb5.DetailHotelActivity;
import com.example.tlb5.Hotel;
import com.example.tlb5.R;

import java.util.List;


public class HomeViewModel extends RecyclerView.Adapter<HomeViewModel.MyViewHolder> {

    static Context mContext;
    List<Hotel> mData;

    public HomeViewModel(Context mContext, List<Hotel> mData){
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_home, parent, false);
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

            titleTextView = itemView.findViewById(R.id.hotelTextView);
            titleStreet = itemView.findViewById(R.id.streetTextView);
            imageView = itemView.findViewById(R.id.hotelImageView);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Hotel items = mData.get(position);

            Intent intent = new Intent(mContext, DetailHotelActivity.class);
            intent.putExtra("image", items.getImageResource());
            intent.putExtra("title", items.getTitle());
            intent.putExtra("street", items.getStreet());
            intent.putExtra("time", items.getTime());
            intent.putExtra("reit", items.getReit());
            mContext.startActivity(intent);
        }
    }
}
package com.example.tlb5.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tlb5.Hotel;
import com.example.tlb5.R;
import com.example.tlb5.RecyclerHotelViewAdapter;
import com.example.tlb5.Util;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    View v;
    private RecyclerView recyclerView;
    private List<Hotel> list;

    public HomeFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_home, container, false);
        recyclerView = v.findViewById(R.id.hotel_recyclerview);
        RecyclerHotelViewAdapter adapter = new RecyclerHotelViewAdapter(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        list.add(new Hotel(R.drawable.hotel1, Util.hotel_title1, Util.hotel_street1, Util.hotel_reit1, Util.hotel_time1));
        list.add(new Hotel(R.drawable.hotel2, Util.hotel_title2, Util.hotel_street2, Util.hotel_reit2, Util.hotel_time2));
        list.add(new Hotel(R.drawable.hotel3, Util.hotel_title3, Util.hotel_street3, Util.hotel_reit3, Util.hotel_time3));

    }
}

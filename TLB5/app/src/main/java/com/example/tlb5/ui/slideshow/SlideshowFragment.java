package com.example.tlb5.ui.slideshow;

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

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    View v;
    private RecyclerView recyclerView;
    private List<Hotel> list;

    public SlideshowFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_slideshow, container, false);
        recyclerView = v.findViewById(R.id.slide_recyclerview);
        RecyclerHotelViewAdapter adapter = new RecyclerHotelViewAdapter(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        list.add(new Hotel(R.drawable.musluvr, Util.museum_title1, Util.museum_street1, Util.museum_reit1, Util.museum_time1));
        list.add(new Hotel(R.drawable.musorse, Util.museum_title2, Util.museum_street2, Util.museum_reit2, Util.museum_time2));
        list.add(new Hotel(R.drawable.musversal, Util.museum_title3, Util.museum_street3, Util.museum_reit3, Util.museum_time3));

    }
}

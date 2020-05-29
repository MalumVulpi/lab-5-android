package com.example.tlb5.ui.gallery;

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

import com.example.tlb5.R;
import com.example.tlb5.RecyclerRestViewAdapter;
import com.example.tlb5.Rest;
import com.example.tlb5.Util;

import java.util.ArrayList;
import java.util.List;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    View v;
    private RecyclerView recyclerView;
    private List<Rest> list;

    public GalleryFragment(){
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = inflater.inflate(R.layout.fragment_gallery, container, false);
        recyclerView = v.findViewById(R.id.rest_recyclerview);
        RecyclerRestViewAdapter adapter = new RecyclerRestViewAdapter(getContext(), list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        list = new ArrayList<>();
        list.add(new Rest(R.drawable.rest1, Util.rest_title1, Util.rest_street1, Util.rest_reit1, Util.rest_time1));
        list.add(new Rest(R.drawable.rest2, Util.rest_title2, Util.rest_street2, Util.rest_reit2, Util.rest_time2));
        list.add(new Rest(R.drawable.rest3, Util.rest_title3, Util.rest_street3, Util.rest_reit3, Util.rest_time3));

    }



}

package com.example.fragmentexample;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class ListFragment extends Fragment {

    // TODO: Rename and change types of parameters
    Button mDetail1Btn;
    Button mDetail2Btn;
    Button mDetail3Btn;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mDetail1Btn = view.findViewById(R.id.detail1Btn);
        mDetail1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailView(1);
            }
        });

        mDetail2Btn = view.findViewById(R.id.detail2Btn);
        mDetail2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailView(2);
            }
        });

        mDetail3Btn = view.findViewById(R.id.detail3Btn);
        mDetail3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                detailView(3);
            }
        });
        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iListFragment= (IListFragment) context;
    }

    void detailView(int itemId){
        iListFragment.viewDetail(itemId);
    }

    IListFragment iListFragment;
    public interface IListFragment{
        void viewDetail(int itemId);
    }
}
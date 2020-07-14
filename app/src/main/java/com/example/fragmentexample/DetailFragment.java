package com.example.fragmentexample;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.service.autofill.Dataset;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.IdentityHashMap;

public class DetailFragment extends Fragment {

    private int itemId;

    public DetailFragment() {
        // Required empty public constructor
    }

    public void setItemId(int itemId){
        this.itemId=itemId;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layoutRoot=inflater.inflate(R.layout.fragment_detail,container,false);
        return layoutRoot;
    }

    private IDetailFragment iDetailFragment;

    public interface IDetailFragment{
        void itemClick(String content);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        iDetailFragment=(IDetailFragment) context;
    }

    public void sendDataToActivity(String content){

        iDetailFragment.itemClick(content);
    }

    @Override
    public void onStart() {
        super.onStart();

        Bundle bundle=getArguments();
        if(bundle!=null){
            itemId=bundle.getInt("itemId");
        }

        View view=getView();
        if(view!=null){
            DataItem item= DataService.getItem(itemId);
            TextView title=view.findViewById(R.id.textTile);
            title.setText(item.getName());
            title.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView textView=(TextView) view;
                    sendDataToActivity(textView.getText().toString());
                }
            });

            TextView desc=view.findViewById(R.id.textDescription);
            desc.setText(item.getDescription());
            desc.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    TextView textView=(TextView) view;
                    sendDataToActivity(textView.getText().toString());
                }
            });
        }
    }
}
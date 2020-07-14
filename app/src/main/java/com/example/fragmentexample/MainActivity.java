package com.example.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements ListFragment.IListFragment,DetailFragment.IDetailFragment {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void viewDetail(int itemId) {
        View fragmentContainer=findViewById(R.id.fragment_container);
        if(fragmentContainer!=null){
            replaceDetailFragment(itemId);
        }
        else{
            startDetailActivity(itemId);
        }

    }

    void startDetailActivity(int itemId){
        Intent intent=new Intent(this,DetailActivity.class);
        intent.putExtra("id",itemId);
        startActivity(intent);
    }

    public void replaceDetailFragment(int itemId){
        Bundle bundle=new Bundle();
        bundle.putInt("itemId",itemId);

        DetailFragment fragment=new DetailFragment();
        fragment.setArguments(bundle);

        FragmentManager fm=getSupportFragmentManager();
        FragmentTransaction trans=fm.beginTransaction();
        trans.replace(R.id.fragment_container,fragment);
        trans.addToBackStack(null);
        trans.commit();
    }

    @Override
    public void itemClick(String content) {
        Toast.makeText(this,content,Toast.LENGTH_LONG).show();
    }
}
package com.example.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class DetailActivity extends AppCompatActivity implements DetailFragment.IDetailFragment{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent=getIntent();
        int itemId=intent.getIntExtra("id",1);

        FragmentManager fm=getSupportFragmentManager();
        DetailFragment fragment=(DetailFragment) fm.findFragmentById(R.id.fragment_detail);
        fragment.setItemId(itemId);
    }

    @Override
    public void itemClick(String content) {
        Toast.makeText(this,content,Toast.LENGTH_LONG).show();
    }
}
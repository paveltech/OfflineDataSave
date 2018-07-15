package com.example.lolipop.offlinedatasave;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.databse.DatabaseManager;
import com.example.lolipop.offlinedatasave.DataAdapter.onClick;
import com.logicclass.JsonFormate;
import com.pojo.DataItem;

import java.util.ArrayList;

public class ShowActivity extends AppCompatActivity implements onClick{

    RecyclerView recyclerView;
    public DataAdapter adapter;
    public DatabaseManager databaseManager;
    public ArrayList<DataItem> dataItemArrayList;
    public JsonFormate jsonFormate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        databaseManager = new DatabaseManager(getApplicationContext());
        dataItemArrayList = new ArrayList<>();
        dataItemArrayList = databaseManager.getCheckList();
        adapter = new DataAdapter(getApplicationContext() , dataItemArrayList , this);
        recyclerView.setAdapter(adapter);
        jsonFormate = new JsonFormate(getApplicationContext());
    }

    @Override
    public void show(DataItem dataItem, int position) {
        Log.d("TAG" , ""+jsonFormate.getJson(dataItem.getData()));
    }


}

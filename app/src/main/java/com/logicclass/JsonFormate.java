package com.logicclass;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.databse.DatabaseManager;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.pojo.DataItem;

import java.util.ArrayList;

public class JsonFormate {

    public Context context;
    public DataItem dataItem;
    public ArrayList<DataItem> dataItemArrayList;
    public Gson gson;
    public DatabaseManager databaseManager;
    String personalInfoJson;

    public JsonFormate(Context context){
        this.context = context;
        dataItem = new DataItem();
        dataItemArrayList = new ArrayList<>();
        gson = new Gson();
        databaseManager = new DatabaseManager(context.getApplicationContext());
    }

    public JsonFormate(){

    }

    public void getData(DataItem dataItem){
        dataItemArrayList.add(
                new DataItem(dataItem.getPerson_name(),
                        dataItem.getPerson_date(),
                        dataItem.getArea(),
                        dataItem.getMailingAddress(),
                        dataItem.getCity(),
                        dataItem.getMobileNumber(),
                        dataItem.getEmailAddress(),
                        dataItem.getOtherBrands(),
                        dataItem.getGenerInfo(),
                        dataItem.getSmokkingBrand())
        );

        convertToJson(dataItemArrayList);
    }


    public String convertToJson(ArrayList<DataItem> dataItemArrayList){
        personalInfoJson = gson.toJson(dataItemArrayList);
        Log.d("JSON" , ""+personalInfoJson.toString());
        return personalInfoJson;
    }

    public String getJson(){
        return personalInfoJson;
    }

    public ArrayList<DataItem> getJson(String value){
        if (!value.isEmpty()){
            Gson gson = new Gson();
            ArrayList<DataItem> newArrayList = gson.fromJson(value , new TypeToken<ArrayList<DataItem>>(){}.getType());
            if (!newArrayList.isEmpty()&& newArrayList.size()>0){
                Log.d("TAG" , ""+newArrayList.toString());
                return newArrayList;
            }
            else {
                Toast.makeText(context.getApplicationContext(), "array list null", Toast.LENGTH_SHORT).show();
            }
        }
        return null;
    }

}

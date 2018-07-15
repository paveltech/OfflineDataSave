package com.example.lolipop.offlinedatasave;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.pojo.DataItem;

import java.util.ArrayList;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.CustomAdapter>{

    public Context context;
    public ArrayList<DataItem> dataItemArrayList;
    public onClick onClick;

    public DataAdapter(Context context , ArrayList<DataItem> dataItemArrayList , onClick onClick){
        this.context = context;
        this.dataItemArrayList = dataItemArrayList;
        this.onClick = onClick;
    }

    @Override
    public CustomAdapter onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_item , parent , false);
        CustomAdapter customAdapter = new CustomAdapter(view);
        return customAdapter;
    }



    @Override
    public void onBindViewHolder(final CustomAdapter holder, int position) {
        final DataItem dataItem = dataItemArrayList.get(position);
        //Toast.makeText(context.getApplicationContext(), ""+, Toast.LENGTH_SHORT).show();
        holder.name.setText(dataItem.getTitle());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClick.show(dataItem , holder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataItemArrayList.size();
    }

    public class CustomAdapter extends RecyclerView.ViewHolder{
        TextView name;
        View view;
        public CustomAdapter(View itemView) {
            super(itemView);
            view = itemView;
            name = (TextView) itemView.findViewById(R.id.title);
        }
    }


    public interface onClick{
        void show(DataItem dataItem , int position);
    }
}

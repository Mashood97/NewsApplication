package com.example.okcomputers.newsapplication;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by OK Computers on 10/13/2018.
 */

public class HomeListAdapter extends RecyclerView.Adapter<HomeListAdapter.ViewHolder> {

    private Context context;
    private ArrayList<HashMap<String,String>> arraynews;

    public HomeListAdapter(Context ctx,ArrayList<HashMap<String,String>> hmap)
    {
     context = ctx;
     arraynews = hmap;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View mRowView = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_list_row,parent,false);
        ViewHolder vh = new ViewHolder(mRowView);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        HashMap<String,String>  maps = arraynews.get(position);
        Glide.with(context).load(maps.get("Url")).into(holder.imgBanner);
        holder.titlenews.setText(maps.get("title"));
        holder.titledesc.setText(maps.get("details"));
    }

    @Override
    public int getItemCount() {
        return arraynews.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgBanner;
        TextView titlenews;
        TextView titledesc;
        public ViewHolder(View itemView) {
            super(itemView);
            imgBanner = (ImageView) itemView.findViewById(R.id.img);
            titlenews = (TextView) itemView.findViewById(R.id.title);
            titledesc = (TextView) itemView.findViewById(R.id.description);
        }
    }
}

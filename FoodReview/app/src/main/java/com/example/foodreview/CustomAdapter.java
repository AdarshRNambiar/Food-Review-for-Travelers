package com.example.foodreview;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {
    Context context;
    ArrayList<Food> foodclass;

    public CustomAdapter(Context context, ArrayList<Food> fd) {
        this.context =context;
        foodclass=fd;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {//represent single row
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.row_item,null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Picasso.get().load(foodclass.get(position).getFoodImage()).into(holder.img);
        Log.d("picas",foodclass.get(position).getFoodImage());
        holder.tv.setText(foodclass.get(position).getFoodname());
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,foodditemdetail.class);
                intent.putExtra("fname",foodclass.get(position).getFoodname());
                intent.putExtra("fimg",foodclass.get(position).getFoodImage());
                intent.putExtra("fdis",foodclass.get(position).getDiscription());
                intent.putExtra("flink",foodclass.get(position).getLinkit());
                intent.putExtra("frate",foodclass.get(position).getFoodrate());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return foodclass.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView img;
        LinearLayout linearLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.viewimageit);
            tv =itemView.findViewById(R.id.viewtextit);
            linearLayout = itemView.findViewById(R.id.rowitemlinearlayout);

        }
    }
}

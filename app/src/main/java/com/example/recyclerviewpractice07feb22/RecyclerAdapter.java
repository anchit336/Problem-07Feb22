package com.example.recyclerviewpractice07feb22;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    Context context;
    ArrayList<ModelClass> list;

    public RecyclerAdapter(Context context, ArrayList<ModelClass> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item, parent, false);
        return  new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {

        holder.Image.setImageResource(list.get(position).UserProfile);
        holder.Name.setText(list.get(position).UserName);
        holder.About.setText(list.get(position).UserAbout);

        holder.Image.setOnClickListener(view -> {

            Intent intent = new Intent(context, TabLayoutActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        });

        holder.Name.setOnClickListener(view -> {

            Intent intent = new Intent(context, TabLayoutActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        });

        holder.About.setOnClickListener(view -> {

            Intent intent = new Intent(context, TabLayoutActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);

        });


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        CircleImageView Image;
        TextView Name, About;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            Image = itemView.findViewById(R.id.profile);
            Name = itemView.findViewById(R.id.name);
            About = itemView.findViewById(R.id.about);
        }
    }
}

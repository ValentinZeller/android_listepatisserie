package com.example.listepatisserie;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class rec_adapter extends RecyclerView.Adapter<rec_adapter.ViewHolder> {
    private ArrayList<Patisserie> patisseries;
    private Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView mNom;
        public TextView mPrix;
        public ImageView mImageView;

        public ViewHolder(View v) {
            super(v);
            mNom = (TextView)v.findViewById(R.id.nom);
            mPrix = (TextView)v.findViewById(R.id.prix);
            mImageView = (ImageView)v.findViewById(R.id.imageView);
        }
    }

    public rec_adapter(ArrayList<Patisserie> patisseries, Context context) {
        this.patisseries = patisseries;
        this.context = context;
    }

    @Override
    public rec_adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.mNom.setText(patisseries.get(position).getName());
        holder.mImageView.setImageDrawable(patisseries.get(position).getImg());
        String prixTxt = "Prix : "+patisseries.get(position).getPrix()+" €";
        holder.mPrix.setText(prixTxt);

        Animation animation = AnimationUtils.loadAnimation(context,R.anim.up);
        holder.itemView.startAnimation(animation);
    }

    @Override
    public int getItemCount() {
        return patisseries.size();
    }
}

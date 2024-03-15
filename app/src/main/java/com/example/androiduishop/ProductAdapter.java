package com.example.androiduishop;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ProductModel> list;

    public ProductAdapter(Context context, ArrayList<ProductModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ProductAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_items, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.MyViewHolder holder, int position) {
        ProductModel data = list.get(position);
        holder.appPrice.setText("Taka: "+ data.getAppPrice());
        holder.appName.setText(data.getAppName());

        //https://drive.google.com/uc?export=view&id=1UL5JNZ1iCJVmU7ZPSzfNf76Csilo1vRa
        String defaultLink = "https://drive.google.com/uc?export=view&id=";
        String imageUrl = data.getAppImgLink();
        //Picasso.get().load(imageUrl).into(holder.appImage);
        Glide.with(context).load(defaultLink + imageUrl).into(holder.appImage);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView appImage;
        TextView appName, appPrice;

        public MyViewHolder(@NonNull View view) {
            super(view);

            appImage = view.findViewById(R.id.app_image);
            appName = view.findViewById(R.id.app_name);
            appPrice = view.findViewById(R.id.app_price);

        }
    }
}

package com.example.androiduishop;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
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

        String postStatus = data.getStatus();

        //https://drive.google.com/uc?export=view&id=1UL5JNZ1iCJVmU7ZPSzfNf76Csilo1vRa
        String defaultLink = "https://drive.google.com/uc?export=view&id=";
        String imageUrl = data.getAppThumb();
        Glide.with(context).load(defaultLink + imageUrl).into(holder.appImage);

        holder.appName.setText(data.getAppName());
        holder.appPrice.setText("Taka: "+ data.getAppPrice());
        holder.appBeforePrice.setPaintFlags(holder.appBeforePrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        holder.appBeforePrice.setText(data.getAppOldPrice());
        holder.salesCount.setText("Sales: "+data.getSale());
        holder.appDesc.setText(data.getAppDesc());

        holder.appView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ProductDetails.class);
                intent.putExtra("id", data.getId());
                intent.putExtra("app_thumb", data.getAppThumb());
                intent.putExtra("app_price", data.getAppPrice());
                intent.putExtra("app_before_price", data.getAppOldPrice());
                intent.putExtra("app_name", data.getAppName());
                intent.putExtra("app_sale", data.getSale());
                intent.putExtra("app_desc", data.getAppDesc());
                intent.putExtra("image_one", data.getImageOne());
                intent.putExtra("image_two", data.getImageTwo());
                intent.putExtra("image_three", data.getImageThree());
                intent.putExtra("image_four", data.getImageFour());
                intent.putExtra("image_five", data.getImageFive());
                intent.putExtra("image_six", data.getImageSix());
                intent.putExtra("image_seven", data.getImageSeven());
                intent.putExtra("image_eight", data.getImageEight());
                intent.putExtra("image_nine", data.getImageNine());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView appImage, addInCart;
        TextView appPrice, appBeforePrice, appName, salesCount, appDesc, appView;

        public MyViewHolder(@NonNull View view) {
            super(view);

            appImage = view.findViewById(R.id.app_image);
            addInCart = view.findViewById(R.id.add_cart);
            appPrice = view.findViewById(R.id.app_price);
            appBeforePrice = view.findViewById(R.id.app_before_price);
            appName = view.findViewById(R.id.app_name);
            salesCount = view.findViewById(R.id.app_sale);
            appDesc = view.findViewById(R.id.app_description);
            appView = view.findViewById(R.id.app_view);

        }
    }
}

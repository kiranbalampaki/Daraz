package com.example.daraz.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.daraz.R;
import com.example.daraz.model.Product;
import com.example.daraz.url.URL;
import com.squareup.picasso.Picasso;

import java.util.List;

public class productAdapter extends RecyclerView.Adapter<productAdapter.ItemViewHolder>  {

    Context context;

    List<Product> itemList;
    public productAdapter(Context context, List<Product> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public productAdapter.ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.product,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull productAdapter.ItemViewHolder holder, int position) {
        final Product item=itemList.get(position);
        holder.tvName.setText(item.getName());
        holder.tvDescription.setText(item.getDescription());
        holder.tvPrice.setText(item.getPrice() + "");
        holder.tvDiscountRate.setText(item.getDiscount_rate() + "");
        holder.tvRating.setText(item.getRating() + "");
      Picasso.get().load(URL.base_url_image+itemList.get(position).getImage()).into(holder.imgImage);
        //Picasso.get().load(Url.base_url_image+itemList.get(position).getProductImage()).into(holder.imgImage);

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder{
        ImageView imgImage;
        TextView tvName, tvDescription, tvPrice, tvDiscountRate, tvRating;
        public ItemViewHolder(@NonNull View itemView){
            super(itemView);
            imgImage=itemView.findViewById(R.id.ivProductImage);
            tvName=itemView.findViewById(R.id.tvProduct_name);
            tvDescription=itemView.findViewById(R.id.tvDescription);
            tvPrice=itemView.findViewById(R.id.tvPrice);
            tvDiscountRate=itemView.findViewById(R.id.tvDiscountRate);
            tvRating=itemView.findViewById(R.id.tvRating);
        }
    }
}

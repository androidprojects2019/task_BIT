package com.example.bit_task.UI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.bit_task.Api.Model.DataItem;
import com.example.bit_task.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.viewHolder> {

    List<DataItem> homeItems;

    public HomeAdapter(List<DataItem> homeItems) {
        this.homeItems = homeItems;
    }


    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_home_card, parent, false);
        return new viewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, final int position) {
        DataItem item = homeItems.get(position);
        Glide.with(holder.itemView).load(item.getImage()).into(holder.photo);
        if (onItemClick != null) {
            holder.photo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClick.onItemClick(position, homeItems.get(position));
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        if (homeItems == null) return 0;
        return homeItems.size();
    }

    public void changeData(List<DataItem> homeItems) {
        this.homeItems = homeItems;
        notifyDataSetChanged();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        ImageView photo;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            photo = itemView.findViewById(R.id.home_image);
        }
    }

    public void setOnItemClick(OnItemClickListener onItemClick) {
        this.onItemClick = onItemClick;
    }

    OnItemClickListener onItemClick;

    public interface OnItemClickListener {
        void onItemClick(int pos, DataItem item);
    }
}

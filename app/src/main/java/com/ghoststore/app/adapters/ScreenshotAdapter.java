package com.ghoststore.app.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.ghoststore.app.R;
import java.util.List;

public class ScreenshotAdapter extends RecyclerView.Adapter<ScreenshotAdapter.SSViewHolder> {
    private Context context;
    private List<String> list;

    public ScreenshotAdapter(Context context, List<String> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SSViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SSViewHolder(LayoutInflater.from(context).inflate(R.layout.item_screenshot, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SSViewHolder holder, int position) {
        Glide.with(context).load(list.get(position)).into(holder.ivScreenshot);
    }

    @Override
    public int getItemCount() { return list.size(); }

    static class SSViewHolder extends RecyclerView.ViewHolder {
        ImageView ivScreenshot;
        public SSViewHolder(@NonNull View itemView) {
            super(itemView);
            ivScreenshot = itemView.findViewById(R.id.ivScreenshot);
        }
    }
}

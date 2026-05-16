package com.ghoststore.app.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.ghoststore.app.DetailsActivity;
import com.ghoststore.app.R;
import com.ghoststore.app.models.AppModel;
import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.AppViewHolder> {
    private Context context;
    private List<AppModel> appList;

    public AppAdapter(Context context, List<AppModel> appList) {
        this.context = context;
        this.appList = appList;
    }

    public void filterList(List<AppModel> filteredList) {
        this.appList = filteredList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public AppViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_app, parent, false);
        return new AppViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AppViewHolder holder, int position) {
        AppModel app = appList.get(position);
        holder.tvName.setText(app.getName());
        holder.tvDeveloper.setText(app.getDeveloper());
        holder.tvRating.setText(app.getRating());
        holder.tvSize.setText(app.getSize());

        Glide.with(context).load(app.getIcon()).into(holder.ivIcon);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailsActivity.class);
            intent.putExtra("app_data", app);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return appList.size();
    }

    static class AppViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvDeveloper, tvRating, tvSize;
        ImageView ivIcon;
        public AppViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvDeveloper = itemView.findViewById(R.id.tvDeveloper);
            tvRating = itemView.findViewById(R.id.tvRating);
            tvSize = itemView.findViewById(R.id.tvSize);
            ivIcon = itemView.findViewById(R.id.ivIcon);
        }
    }
}

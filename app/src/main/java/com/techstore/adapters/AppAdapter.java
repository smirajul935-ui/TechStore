package com.techstore.adapters;
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
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.techstore.DetailsActivity;
import com.techstore.R;
import com.techstore.models.AppModel;
import java.util.List;

public class AppAdapter extends RecyclerView.Adapter<AppAdapter.ViewHolder> {
    private Context context; private List<AppModel> list;
    public AppAdapter(Context c, List<AppModel> l) { context=c; list=l; }
    public void filterList(List<AppModel> f) { list=f; notifyDataSetChanged(); }
    @NonNull @Override public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_app, parent, false)); }
    @Override public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        AppModel model = list.get(position); holder.appName.setText(model.name); holder.appDev.setText(model.developer); holder.appRating.setText(model.rating + " ★ | " + model.size); Glide.with(context).load(model.icon).transform(new RoundedCorners(24)).into(holder.appIcon);
        holder.itemView.setOnClickListener(v -> { Intent intent = new Intent(context, DetailsActivity.class); intent.putExtra("app_data", model); context.startActivity(intent); });
    }
    @Override public int getItemCount() { return list.size(); }
    public static class ViewHolder extends RecyclerView.ViewHolder { ImageView appIcon; TextView appName, appDev, appRating; public ViewHolder(@NonNull View itemView) { super(itemView); appIcon = itemView.findViewById(R.id.appIcon); appName = itemView.findViewById(R.id.appName); appDev = itemView.findViewById(R.id.appDev); appRating = itemView.findViewById(R.id.appRating); } }
}

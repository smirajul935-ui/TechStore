package com.ghoststore.app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.ghoststore.app.adapters.ScreenshotAdapter;
import com.ghoststore.app.models.AppModel;
import com.ghoststore.app.utils.DownloadHelper;

public class DetailsActivity extends AppCompatActivity {
    private AppModel appData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        appData = (AppModel) getIntent().getSerializableExtra("app_data");
        if (appData == null) { finish(); return; }

        ImageView ivBanner = findViewById(R.id.ivBanner);
        ImageView ivIcon = findViewById(R.id.ivIcon);
        TextView tvName = findViewById(R.id.tvName);
        TextView tvDeveloper = findViewById(R.id.tvDeveloper);
        TextView tvDescription = findViewById(R.id.tvDescription);
        Button btnDownload = findViewById(R.id.btnDownload);
        RecyclerView rvScreenshots = findViewById(R.id.rvScreenshots);
        TextView tvTerms = findViewById(R.id.tvTerms);

        Glide.with(this).load(appData.getBanner()).into(ivBanner);
        Glide.with(this).load(appData.getIcon()).into(ivIcon);
        tvName.setText(appData.getName());
        tvDeveloper.setText(appData.getDeveloper());
        tvDescription.setText(appData.getDescription());

        rvScreenshots.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        if (appData.getScreenshots() != null) {
            rvScreenshots.setAdapter(new ScreenshotAdapter(this, appData.getScreenshots()));
        }

        btnDownload.setOnClickListener(v -> DownloadHelper.downloadApk(this, appData.getDownload(), appData.getName()));

        tvTerms.setOnClickListener(v -> startActivity(new Intent(DetailsActivity.this, TermsActivity.class)));
    }
}

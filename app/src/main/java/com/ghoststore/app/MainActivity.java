package com.ghoststore.app;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.ghoststore.app.adapters.AppAdapter;
import com.ghoststore.app.models.AppModel;
import com.ghoststore.app.utils.JsonHelper;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvApps;
    private AppAdapter adapter;
    private List<AppModel> appList = new ArrayList<>();
    private SwipeRefreshLayout swipeRefresh;
    private ProgressBar progressBar;
    private EditText etSearch;
    private LinearLayout categoryContainer;
    private ImageView btnUpload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvApps = findViewById(R.id.rvApps);
        swipeRefresh = findViewById(R.id.swipeRefresh);
        progressBar = findViewById(R.id.progressBar);
        etSearch = findViewById(R.id.etSearch);
        categoryContainer = findViewById(R.id.categoryContainer);
        btnUpload = findViewById(R.id.btnUpload);

        rvApps.setLayoutManager(new LinearLayoutManager(this));
        adapter = new AppAdapter(this, appList);
        rvApps.setAdapter(adapter);

        btnUpload.setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://t.me/SagarTech99"));
            startActivity(intent);
        });

        swipeRefresh.setOnRefreshListener(this::loadData);

        setupSearch();
        loadData();
    }

    private void loadData() {
        progressBar.setVisibility(View.VISIBLE);
        JsonHelper.fetchApps(this, new JsonHelper.FetchCallback() {
            @Override
            public void onSuccess(List<AppModel> apps) {
                appList.clear();
                appList.addAll(apps);
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
                swipeRefresh.setRefreshing(false);
                setupCategories();
            }

            @Override
            public void onError(String error) {
                progressBar.setVisibility(View.GONE);
                swipeRefresh.setRefreshing(false);
                Toast.makeText(MainActivity.this, "Error loading apps", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setupSearch() {
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }
            @Override
            public void afterTextChanged(Editable s) {}
        });
    }

    private void filter(String text) {
        List<AppModel> filtered = new ArrayList<>();
        for (AppModel app : appList) {
            if (app.getName().toLowerCase().contains(text.toLowerCase()) || 
                app.getCategory().toLowerCase().contains(text.toLowerCase())) {
                filtered.add(app);
            }
        }
        adapter.filterList(filtered);
    }

    private void setupCategories() {
        categoryContainer.removeAllViews();
        String[] cats = {"All", "Games", "VPN", "Tools", "MOD", "Social"};
        for (String cat : cats) {
            TextView tv = new TextView(this);
            tv.setText(cat);
            tv.setTextColor(Color.WHITE);
            tv.setPadding(40, 20, 40, 20);
            tv.setBackgroundResource(R.drawable.bg_search);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            params.setMargins(0, 0, 20, 0);
            tv.setLayoutParams(params);
            
            tv.setOnClickListener(v -> {
                if(cat.equals("All")) adapter.filterList(appList);
                else filter(cat);
            });
            categoryContainer.addView(tv);
        }
    }
}

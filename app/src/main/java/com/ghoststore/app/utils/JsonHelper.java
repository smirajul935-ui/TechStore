package com.ghoststore.app.utils;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.ghoststore.app.models.AppModel;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class JsonHelper {
    public interface FetchCallback {
        void onSuccess(List<AppModel> apps);
        void onError(String error);
    }

    public static void fetchApps(Context context, FetchCallback callback) {
        String URL = "https://pastebin.com/raw/NazABkD4";
        RequestQueue queue = Volley.newRequestQueue(context);

        StringRequest request = new StringRequest(Request.Method.GET, URL, response -> {
            try {
                List<AppModel> appList = new ArrayList<>();
                JSONArray array = new JSONArray(response);
                for (int i = 0; i < array.length(); i++) {
                    JSONObject obj = array.getJSONObject(i);
                    AppModel app = new AppModel();
                    app.setName(obj.optString("name"));
                    app.setDeveloper(obj.optString("developer"));
                    app.setVersion(obj.optString("version"));
                    app.setSize(obj.optString("size"));
                    app.setRating(obj.optString("rating"));
                    app.setIcon(obj.optString("icon"));
                    app.setBanner(obj.optString("banner"));
                    app.setDownload(obj.optString("download"));
                    app.setDescription(obj.optString("description"));
                    app.setCategory(obj.optString("category"));
                    
                    List<String> screens = new ArrayList<>();
                    JSONArray ssArray = obj.optJSONArray("screenshots");
                    if (ssArray != null) {
                        for (int j = 0; j < ssArray.length(); j++) {
                            screens.add(ssArray.getString(j));
                        }
                    }
                    app.setScreenshots(screens);
                    appList.add(app);
                }
                callback.onSuccess(appList);
            } catch (Exception e) {
                callback.onError(e.getMessage());
            }
        }, error -> callback.onError(error.toString()));

        queue.add(request);
    }
}

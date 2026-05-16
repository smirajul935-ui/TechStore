package com.techstore.utils;
import android.app.DownloadManager; import android.content.Context; import android.net.Uri; import android.os.Environment; import android.widget.Toast;
public class DownloadHelper {
    public static void startDownload(Context context, String url, String title) {
        try {
            DownloadManager.Request request = new DownloadManager.Request(Uri.parse(url));
            request.setTitle(title); request.setDescription("Downloading " + title);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, title + ".apk");
            DownloadManager manager = (DownloadManager) context.getSystemService(Context.DOWNLOAD_SERVICE);
            manager.enqueue(request);
            Toast.makeText(context, "Download Started! Check Notifications.", Toast.LENGTH_LONG).show();
        } catch (Exception e) { Toast.makeText(context, "Error: " + e.getMessage(), Toast.LENGTH_SHORT).show(); }
    }
}

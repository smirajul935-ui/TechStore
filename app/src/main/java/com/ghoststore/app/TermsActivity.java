package com.ghoststore.app;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class TermsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_terms);

        TextView tvTermsText = findViewById(R.id.tvTermsText);
        String terms = "Welcome to Ghost Store / Tech Store.\n\n" +
                "By using this application, you agree to all terms & conditions mentioned below.\n\n" +
                "1. All APK files available in this app are provided by third-party developers or sources. Ghost Store / Tech Store does not claim ownership of any APK unless stated otherwise.\n\n" +
                "2. Any APK downloaded or installed from this app is completely at the user’s own risk and responsibility.\n\n" +
                "3. Ghost Store / Tech Store and its developer will NOT be responsible for:\n" +
                "• Device damage\n• Data loss\n• Account ban/suspension\n• Malware or virus issues\n• Security problems\n• Performance issues\n• Any legal issues caused by third-party APKs\n\n" +
                "4. Users are strongly advised to verify and scan APK files before installing them.\n\n" +
                "5. Some download links may redirect to third-party platforms like GitHub, Telegram, cloud storage, or external websites. We are not responsible for the content or availability of those platforms.\n\n" +
                "6. If any developer or owner has copyright concerns regarding any content, they may contact us for removal.\n\n" +
                "7. Ghost Store / Tech Store may modify, remove, or discontinue any APK or feature at any time without notice.\n\n" +
                "By continuing to use this application, you confirm that you understand and accept all these terms.\n\n" +
                "USE ALL APKs AT YOUR OWN RISK.\n" +
                "THE DEVELOPER OF GHOST STORE / TECH STORE IS NOT RESPONSIBLE FOR ANY DAMAGE OR ISSUE CAUSED BY THIRD-PARTY APPLICATIONS.";
        
        tvTermsText.setText(terms);
    }
}

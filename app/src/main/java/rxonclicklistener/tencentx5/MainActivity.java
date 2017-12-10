package rxonclicklistener.tencentx5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.LinearLayout;

import com.just.agentwebX5.AgentWeb;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.smtt.sdk.ValueCallback;
import com.tencent.smtt.sdk.WebChromeClient;
import com.tencent.smtt.sdk.WebSettings;
import com.tencent.smtt.sdk.WebView;
import com.tencent.smtt.sdk.WebViewClient;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout linearLayout = findViewById(R.id.linearlayout);

//        AgentWeb.with(this).setAgentWebParent(linearLayout, new LinearLayout.LayoutParams(-1, -1))
//                .useDefaultIndicator().defaultProgressBarColor().closeWebViewClientHelper()
//                .createAgentWeb().ready().go("file:///android_asset/invoice.pdf");

        WebView webView = findViewById(R.id.webview);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowContentAccess(true);
        settings.setAllowFileAccess(true);
        settings.setAllowFileAccessFromFileURLs(true);
        settings.setAppCacheEnabled(true);

        webView.setWebChromeClient(new WebChromeClient());
        webView.setWebViewClient(new WebViewClient());
        QbSdk.openFileReader(this, "file:///android_asset/invoice.pdf", null, new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String s) {
                Log.d(TAG, "onReceiveValue: "+s);
            }
        });
    }
}

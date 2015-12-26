package pl.lukmarr.magicstories;

import android.net.Uri;
import android.os.Bundle;
import android.support.customtabs.CustomTabsIntent;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class WebViewActivity extends AppCompatActivity {
    public static int lastClickedChapter = -1;
    public static final String EXTRA_URL = "extra.url";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Pair<String, String>> list = new ArrayList<>();
        String[] ss = new String[]{
                "http://www.portal24h.pl/kubus-puchatek/51-cz0-phantom-tentacle",
                "http://www.portal24h.pl/kubus-puchatek/52-cz1-mossad-attac",
                "http://www.portal24h.pl/kubus-puchatek/149-cz2-the-rulerz-of-the-worlds",
                "http://www.portal24h.pl/kubus-puchatek/150-cz3-the-silents-of-the-lambs",
                "http://www.portal24h.pl/kubus-puchatek/151-cz4-misteries-of-rain",
                "http://www.portal24h.pl/kubus-puchatek/152-cz5-the-final-conflict",
                "http://www.portal24h.pl/kubus-puchatek/153-cz6-satans-visions",
                "http://www.portal24h.pl/kubus-puchatek/154-cz7-political-fiction",
                "http://www.portal24h.pl/kubus-puchatek/155-cz8-cool-war",
                "http://www.portal24h.pl/kubus-puchatek/156-cz9-merry-x-mas",
                "http://www.portal24h.pl/kubus-puchatek/159-cz10-voodoo-people",
                "http://www.portal24h.pl/kubus-puchatek/157-cz11-one-flew-over-cucoos-nest",
                "http://www.portal24h.pl/kubus-puchatek/158-cz12-where-is-becon",
                "http://www.portal24h.pl/kubus-puchatek/160-cz13-killing-fields",
                "http://www.portal24h.pl/kubus-puchatek/161-cz-14-the-black-case",
                "http://www.portal24h.pl/kubus-puchatek/269-cz-15-saturday-night-fever",
                "http://www.portal24h.pl/kubus-puchatek/270-cz-16-follow-the-white-rabbit",
                "http://www.portal24h.pl/kubus-puchatek/271-cz-17-the-green-power"
        };
        for (int j = 0; j < ss.length; j++) {
            list.add(pair(ss[j], "Chapter " + j));
        }


        recyclerView.setAdapter(new NEW(list, new NEW.Listener() {
            @Override
            public void onClick(int j, String s) {
                lastClickedChapter = j;
                onTitleClick(s);

            }
        }));


        //  String url = getIntent().getStringExtra(EXTRA_URL);
        //WebView webView = (WebView) findViewById(R.id.webview);
        // webView.setWebViewClient(new WebViewClient());
        // WebSettings webSettings = webView.getSettings();
        // webSettings.setJavaScriptEnabled(true);
        //  setTitle(url);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        // webView.loadUrl(url);

    }

    static Pair<String, String> pair(String a, String b) {
        return new Pair<>(a, b);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void onTitleClick(String url) {
        CustomTabsIntent customTabsIntent = new CustomTabsIntent.Builder().build();
        CustomTabActivityHelper.openCustomTab(
                this,// activity
                customTabsIntent,
                Uri.parse(url),
                new WebViewFallback()
        );

    }
}

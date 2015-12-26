package pl.lukmarr.magicstories;

/**
 * Created by Łukasz Marczak
 *
 * @since 26.12.15
 */

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

/**
 * A Fallback that opens a Webview when Custom Tabs is not available
 */
public class WebViewFallback implements CustomTabActivityHelper.CustomTabFallback {
    @Override
    public void openUri(Activity activity, Uri uri) {
        Intent intent = new Intent(activity, WebViewActivity.class);
        intent.putExtra(WebViewActivity.EXTRA_URL, uri.toString());
        activity.startActivity(intent);
    }
}

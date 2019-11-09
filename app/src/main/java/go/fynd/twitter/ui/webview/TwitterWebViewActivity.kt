package go.fynd.twitter.ui.webview

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import go.fynd.twitter.R

class TwitterWebViewActivity : AppCompatActivity() {
    companion object {
        var EXTRA_URL = "URL"
    }

    lateinit var mURL: String
    lateinit var mWebView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_twitter_webview)
        supportActionBar?.hide()
        if (intent != null && intent.hasExtra(EXTRA_URL)) {
            mURL = intent?.extras?.getString(EXTRA_URL)!!
            mWebView = findViewById(R.id.web_view)
            mWebView.webViewClient = object : WebViewClient() {
                override fun shouldOverrideUrlLoading(
                    view: WebView?,
                    request: WebResourceRequest?
                ): Boolean {
                    if (request?.url.toString().contains(getString(R.string.twitter_callback))) {
                        val verifier =
                            request?.url?.getQueryParameter(getString(R.string.twitter_oauth_verifier))
                        val resultIntent = Intent()
                        resultIntent.putExtra(getString(R.string.twitter_oauth_verifier), verifier)
                        setResult(Activity.RESULT_OK, resultIntent)
                        finish()
                        return true
                    } else {
                        return false
                    }
                }
            }
            mWebView.loadUrl(mURL)
        } else {
            Toast.makeText(this, "URL cannot be null!", Toast.LENGTH_LONG).show()
            finish()
        }
    }

}
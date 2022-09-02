package com.sarabyeet.droidnews

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.databinding.DataBindingUtil
import com.sarabyeet.droidnews.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    companion object {
        const val ARG_URL = "_url"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityDetailsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_details)

        val client = object: WebViewClient(){
            override fun onPageFinished(view: WebView?, url: String?) {
                binding.progressBar.hide()
            }
        }
        binding.webView.webViewClient = client
        binding.url = intent.getStringExtra(ARG_URL) ?: ""
    }
}
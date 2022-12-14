package com.sarabyeet.droidnews

import android.webkit.WebView
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.sarabyeet.droidnews.model.DroidNewsItem
import com.sarabyeet.droidnews.newsfeed.DroidNewsHomeAdapter
import com.squareup.picasso.Picasso

// region recycler view adapter
@BindingAdapter("setItems")
fun setItems(recyclerView: RecyclerView, list: List<DroidNewsItem>?) {
    (recyclerView.adapter as DroidNewsHomeAdapter).setItems(list)
}
// endregion recycler view adapter

// region ImageView
@BindingAdapter("loadImageWithPicasso")
fun loadImageWithPicasso(imageView: ImageView, imageUrl: String) {
    Picasso.get().load(imageUrl).into(imageView)
}
// endregion ImageView

// region WebView
@BindingAdapter("loadIntoWebView")
fun loadIntoWebView(webView: WebView, url: String) {
    webView.loadUrl(url)
}
// endregion WebView


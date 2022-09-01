package com.sarabyeet.droidnews

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sarabyeet.droidnews.databinding.DroidNewsViewHolderItemBinding
import com.sarabyeet.droidnews.model.DroidNewsItem

class DroidNewsHomeAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val newsItemList = mutableListOf<DroidNewsItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return NewsFeedItemViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as NewsFeedItemViewHolder).onBind(newsItemList[position])
    }

    override fun getItemCount(): Int {
        return newsItemList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setItems(list: List<DroidNewsItem>?) {
        this.newsItemList.clear()
        this.newsItemList.addAll(list?: emptyList())
        notifyDataSetChanged()
    }

    inner class NewsFeedItemViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.droid_news_view_holder_item, parent, false)
    ) {
        private val binding = DroidNewsViewHolderItemBinding.bind(itemView)
        fun onBind(newsItem: DroidNewsItem) {
            binding.title = newsItem.title
            binding.description = newsItem.description
            binding.published = newsItem.published
            binding.publisher = newsItem.publisher
            binding.imageUrl = newsItem.image_url
        }
    }
}
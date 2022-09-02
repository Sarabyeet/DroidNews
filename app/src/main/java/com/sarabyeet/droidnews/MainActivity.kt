package com.sarabyeet.droidnews

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sarabyeet.droidnews.arch.DroidNewsViewModel
import com.sarabyeet.droidnews.databinding.ActivityMainBinding
import com.sarabyeet.droidnews.newsfeed.DroidNewsHomeAdapter
import com.sarabyeet.droidnews.newsfeed.DroidNewsItemActions
import java.lang.ref.WeakReference

class MainActivity : AppCompatActivity(), DroidNewsItemActions {
    private val viewModel: DroidNewsViewModel by lazy {
        ViewModelProvider(this)[DroidNewsViewModel::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.fetchNews()

        val adapter = DroidNewsHomeAdapter(WeakReference(this))
        binding.rvHome.adapter = adapter

    }

    override fun onFavoriteSelected(id: String, isFavorite: Boolean) {
        viewModel.updateFavoriteStatus(id, isFavorite)
    }

    override fun onNewsItemClicked(url: String) {
        val intent = Intent(this, DetailsActivity::class.java).apply {
            putExtra(DetailsActivity.ARG_URL, url)
        }
        startActivity(intent)
    }
}

package com.sarabyeet.droidnews

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.sarabyeet.droidnews.databinding.ActivityMainBinding
import com.sarabyeet.droidnews.model.DroidNewsItem

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val viewModel = ViewModelProvider(this)[DroidNewsViewModel::class.java]
        val binding : ActivityMainBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_main
        )
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        viewModel.fetchNews()

        val adapter = DroidNewsHomeAdapter()
        binding.rvHome.adapter = adapter

    }
}

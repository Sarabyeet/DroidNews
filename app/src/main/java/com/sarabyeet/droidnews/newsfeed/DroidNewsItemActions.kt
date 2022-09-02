package com.sarabyeet.droidnews.newsfeed

interface DroidNewsItemActions {
    fun onNewsItemClicked(url: String)
    fun onFavoriteSelected(id: String, isFavorite: Boolean)
}
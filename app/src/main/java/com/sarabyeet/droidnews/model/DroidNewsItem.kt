package com.sarabyeet.droidnews.model

data class DroidNewsItem(
    val id: String = "",
    val favorite: Boolean = false,
    val title: String = "",
    val description: String = "",
    val image_url: String = "",
    val publisher: String = "",
    val published: String = "",
    val url: String = "",
)
package com.sarabyeet.droidnews.arch

import androidx.lifecycle.MutableLiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.sarabyeet.droidnews.model.DroidNewsItem

class DroidNewsRepository {
    private val database = Firebase.database
    private val newsFeedRef = database.getReference("news_feed")

    fun fetchNews(liveData: MutableLiveData<List<DroidNewsItem>>) {
        newsFeedRef
            .orderByChild("_rank")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    val droidNewsItems: List<DroidNewsItem> =
                        snapshot.children.map { dataSnapshot ->
                            dataSnapshot.getValue(DroidNewsItem::class.java)!!
                                .copy(id = dataSnapshot.key!!)
                        }

                    liveData.postValue(droidNewsItems)
                }

                override fun onCancelled(error: DatabaseError) {
                    // nothing to do
                }
            })
    }

    fun updateFavoriteStatus(id: String, isFavorite: Boolean) {
        newsFeedRef.child(id).child("favorite").setValue(isFavorite)
    }
}
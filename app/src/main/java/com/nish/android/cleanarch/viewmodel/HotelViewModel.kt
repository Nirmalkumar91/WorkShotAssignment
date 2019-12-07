package com.nish.android.cleanarch.viewmodel

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import com.nish.android.cleanarch.repo.Comment
import com.nish.android.core.BaseViewModel
import javax.inject.Inject

class HotelViewModel @Inject constructor(): BaseViewModel(), LifecycleObserver {

    private val commentList = mutableListOf<Comment>()
    private val commentsLiveData = MutableLiveData<List<Comment>>()

    fun fetchComments(): MutableLiveData<List<Comment>> {
        return commentsLiveData
    }

    fun addComment(name: String, desc: String) {
        commentList.add(Comment("0", desc, name, "0"))
        commentsLiveData.postValue(commentList)
    }
}
package com.nish.android.cleanarch.viewmodel

import androidx.databinding.ObservableField
import com.nish.android.cleanarch.repo.Comment
import com.nish.android.core.BaseViewModel

class CommentViewModel constructor(private val comment: Comment): BaseViewModel() {

    val name = ObservableField<String>()
    val commentData = ObservableField<String>()

    fun populateComment() {
        name.set(comment.user)
        commentData.set(comment.comment)
    }
}
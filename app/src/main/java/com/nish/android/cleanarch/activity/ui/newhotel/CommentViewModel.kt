package com.nish.android.cleanarch.activity.ui.newhotel

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel

class CommentViewModel : ViewModel() {

    val commentName = ObservableField<String>()
    val commentDesc = ObservableField<String>()

}

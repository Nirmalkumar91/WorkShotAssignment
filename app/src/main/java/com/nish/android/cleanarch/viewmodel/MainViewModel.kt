package com.nish.android.cleanarch.viewmodel

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.nish.android.cleanarch.repo.Comment
import com.nish.android.cleanarch.repo.Hotel
import com.nish.android.cleanarch.repo.HotelRepository
import com.nish.android.core.BaseViewModel
import javax.inject.Inject

class MainViewModel @Inject constructor(private val hotelRepository: HotelRepository): BaseViewModel(), LifecycleObserver{

    val hotelName = ObservableField<String>()
    val hotelDesc = ObservableField<String>()
    val hotelLocation = ObservableField<String>()
    val hotelRating = ObservableField<String>()
    val hotelReview = ObservableField<String>()
    val hotelCost = ObservableField<String>()

    lateinit var adapter: CommentsAdapter
    /*fun onGetStartedButtonClick() {
        startNavigationEvent(NavigationEvent(TutorialActivity::class.java, false))
    }*/

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onCreate() {
        hotelRepository.getHotelDetails().subscribe ({ hotel -> setHotelDetails(hotel) }, { throwable -> onNetworkError(throwable) })
        hotelRepository.getHotelComments().subscribe ({ comments -> setHotelComments(comments) }, { throwable -> onNetworkError(throwable) })
    }

    private fun setHotelComments(comments: List<Comment>) {
        adapter.setDataList(comments.map { CommentViewModel(it).apply { populateComment() } })
    }

    private fun setHotelDetails(hotel: Hotel) {
        hotel.apply {
            hotelName.set(this.name)
            hotelDesc.set(this.description)
            hotelLocation.set(this.location)
            hotelRating.set(this.rating)
            hotelReview.set(this.numberOfReviews)
            hotelCost.set(this.cost)
        }
    }
}

    private fun onNetworkError(throwable: Throwable) {
        Log.e("Error", throwable.message, throwable)
    }

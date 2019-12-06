package com.nish.android.cleanarch.repo

interface SaveHotelInterface {

    fun saveHotelDetails(hotel: Hotel)

    fun saveCommentsList(comments: List<Comment>)
}
package com.nish.android.cleanarch.network

import com.nish.android.cleanarch.repo.Comment
import com.nish.android.cleanarch.repo.Hotel
import retrofit2.http.GET
import io.reactivex.Observable

interface HotelService {

    @GET("/workshop/hotel")
    fun getHotel(): Observable<Hotel>

    @GET("/workshop/comments")
    fun getComments(): Observable<List<Comment>>
}
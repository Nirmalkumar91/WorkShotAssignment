package com.nish.android.cleanarch.repo

import io.reactivex.Observable

interface FetchHotelInterface {

    fun getHotelDetails(): Observable<Hotel>

    fun getHotelComments(): Observable<List<Comment>>
}
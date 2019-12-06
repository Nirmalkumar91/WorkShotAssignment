package com.nish.android.cleanarch.repo

import com.nish.android.cleanarch.cache.HotelCacheProvider
import com.nish.android.cleanarch.network.HotelRemoteProvider
import io.reactivex.Observable
import javax.inject.Inject

class HotelRepository @Inject constructor(private val hotelRemoteProvider: HotelRemoteProvider,
                                          private val hotelCacheProvider: HotelCacheProvider) {

    fun getHotelDetails(): Observable<Hotel> {
        return hotelRemoteProvider.getHotelDetails()
    }

    fun getHotelComments(): Observable<List<Comment>> {
        return hotelRemoteProvider.getHotelComments()
    }
}
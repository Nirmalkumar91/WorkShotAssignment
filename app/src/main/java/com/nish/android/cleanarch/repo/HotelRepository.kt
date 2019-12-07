package com.nish.android.cleanarch.repo

import com.nish.android.cleanarch.cache.HotelCacheProvider
import com.nish.android.cleanarch.network.HotelRemoteProvider
import io.reactivex.Observable
import javax.inject.Inject

class HotelRepository @Inject constructor(private val hotelRemoteProvider: HotelRemoteProvider,
                                          private val hotelCacheProvider: HotelCacheProvider
) {

    fun getHotelDetails(): Observable<Hotel> {
        val cacheHotelObservable = hotelCacheProvider.getHotelDetails()
        val remoteHotelObservable = hotelRemoteProvider.getHotelDetails().doOnNext {
            hotelCacheProvider.saveHotelDetails(it)
        }
        return Observable.concat(cacheHotelObservable, remoteHotelObservable)
    }

    fun getHotelComments(): Observable<List<Comment>> {
        val cacheCommentsObservable = hotelCacheProvider.getHotelComments()
        val remoteCommentsObservable = hotelRemoteProvider.getHotelComments().doOnNext {
            hotelCacheProvider.saveCommentsList(it)
        }
        return Observable.concat(cacheCommentsObservable, remoteCommentsObservable)
    }
}
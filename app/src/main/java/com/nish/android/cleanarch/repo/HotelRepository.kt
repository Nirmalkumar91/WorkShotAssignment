package com.nish.android.cleanarch.repo

import com.nish.android.cleanarch.cache.HotelCacheProvider
import com.nish.android.cleanarch.network.HotelRemoteProvider
import io.reactivex.Observable
import javax.inject.Inject

class HotelRepository @Inject constructor(private val hotelRemoteProvider: HotelRemoteProvider,
                                          private val hotelCacheProvider: HotelCacheProvider
): FetchHotelInterface {

    private val cacheHotelObservable = hotelCacheProvider.getHotelDetails()

    private val remoteHotelObservable = hotelRemoteProvider.getHotelDetails().doOnNext {
        hotelCacheProvider.saveHotelDetails(it)
    }

    private val cacheCommentsObservable = hotelCacheProvider.getHotelComments()

    private val remoteCommentsObservable = hotelRemoteProvider.getHotelComments().doOnNext {
        hotelCacheProvider.saveCommentsList(it)
    }

    override fun getHotelDetails(): Observable<Hotel> {
        return Observable.concat(cacheHotelObservable, remoteHotelObservable)
    }

    override fun getHotelComments(): Observable<List<Comment>> {
        return Observable.concat(cacheCommentsObservable, remoteCommentsObservable)
    }
}
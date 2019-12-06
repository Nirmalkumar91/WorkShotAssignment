package com.nish.android.cleanarch.network

import com.nish.android.cleanarch.repo.Comment
import com.nish.android.cleanarch.repo.FetchHotelInterface
import com.nish.android.cleanarch.repo.Hotel
import io.reactivex.Observable
import javax.inject.Inject

class HotelRemoteProvider @Inject constructor(private val service: HotelService,
                                              private val schedulerTransformer: SchedulerTransformer
): FetchHotelInterface {

    override fun getHotelDetails(): Observable<Hotel> {
        return service.getHotel().compose(schedulerTransformer.getSchedulerTransformer())
    }

    override fun getHotelComments(): Observable<List<Comment>> {
        return service.getComments().compose(schedulerTransformer.getSchedulerTransformer())
    }

}
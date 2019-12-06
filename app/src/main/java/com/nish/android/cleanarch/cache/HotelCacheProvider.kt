package com.nish.android.cleanarch.cache

import android.content.SharedPreferences
import android.text.TextUtils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.nish.android.cleanarch.repo.Comment
import com.nish.android.cleanarch.repo.FetchHotelInterface
import com.nish.android.cleanarch.repo.Hotel
import com.nish.android.cleanarch.repo.SaveHotelInterface
import io.reactivex.Observable
import javax.inject.Inject

class HotelCacheProvider @Inject constructor(private val sharedPreference: SharedPreferences,
                                             private val gson: Gson
): FetchHotelInterface, SaveHotelInterface {

    override fun getHotelDetails(): Observable<Hotel> {
        val hotel = sharedPreference.getString(HOTEL_KEY, "")
        return if(!TextUtils.isEmpty(hotel)) {
            Observable.just(gson.fromJson(hotel, Hotel::class.java))
        } else {
            Observable.just(Hotel("", "", "", "", "",""))
            //Observable.error(Exception("Hotel not found"))
        }
    }

    override fun getHotelComments(): Observable<List<Comment>> {
        val comments = sharedPreference.getString(COMMENTS_KEY, "")
        return if(!TextUtils.isEmpty(comments)) {
            Observable.just(gson.fromJson(comments, object: TypeToken<List<Comment>>(){}.type))
        } else {
            Observable.just(emptyList())
        }
    }

    override fun saveHotelDetails(hotel: Hotel) {
        sharedPreference.edit().putString(HOTEL_KEY, gson.toJson(hotel)).commit()
    }

    override fun saveCommentsList(comments: List<Comment>) {
        sharedPreference.edit().putString(COMMENTS_KEY, gson.toJson(comments)).commit()
    }

    companion object {
        const val HOTEL_KEY = "HOTEL_KEY"
        const val COMMENTS_KEY = "COMMENTS_KEY"
    }
}
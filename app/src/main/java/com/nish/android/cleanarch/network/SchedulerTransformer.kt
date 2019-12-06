package com.nish.android.cleanarch.network

import javax.inject.Inject

import io.reactivex.ObservableTransformer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulerTransformer @Inject constructor() {

    fun <T> getSchedulerTransformer(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
        }
    }
}


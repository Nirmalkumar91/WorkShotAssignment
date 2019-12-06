package com.nish.android.core

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nish.android.core.events.NavigationEvent

abstract class BaseViewModel : ViewModel() {

    private val navigationEvent = MutableLiveData<ViewEvent<NavigationEvent>>()

    fun getNavigationEvent() = navigationEvent

    protected fun startNavigationEvent(event : NavigationEvent) {
        navigationEvent.value = ViewEvent(event)
    }

}
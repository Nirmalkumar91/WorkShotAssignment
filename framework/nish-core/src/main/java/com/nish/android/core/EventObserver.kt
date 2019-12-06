package com.nish.android.core

import androidx.lifecycle.Observer
import com.nish.android.core.events.BaseEvent

class EventObserver<T : BaseEvent>(private val onEventUnhandledContent: (T) -> Unit) : Observer<ViewEvent<T>> {
    override fun onChanged(event: ViewEvent<T>?) {
        event?.getContentIfNotHandled()?.let { value ->
            onEventUnhandledContent(value)
        }
    }
}
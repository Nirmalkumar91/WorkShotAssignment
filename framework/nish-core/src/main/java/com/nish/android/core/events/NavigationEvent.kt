package com.nish.android.core.events

import android.content.Intent

class NavigationEvent(val activityClass: Class<*>,
                      val finishActivity: Boolean,
                      val isExternalApp: Boolean = false,
                      val intent: Intent? = null
) : BaseEvent()
package com.nish.android.core

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.nish.android.core.events.NavigationEvent

abstract class BaseActivity : FragmentActivity() {

    protected fun startActivity(event: NavigationEvent) {
        if (event.isExternalApp && event.intent != null) {
            startActivity(event.intent)
            finish()
        } else {
            val startIntent = Intent(this, event.activityClass)
            startActivity(startIntent)
            if (event.finishActivity) finish()
        }
    }

    protected fun registerNavigationEvent(viewModel: BaseViewModel) {
        viewModel.getNavigationEvent().observe(this, EventObserver { startActivity(it) })
    }
}
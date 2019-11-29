package com.nish.android.cleanarch

import android.app.Activity
import android.app.Application
import com.nish.android.cleanarch.di.ApplicationComponent
import com.nish.android.cleanarch.di.ApplicationModule
import com.nish.android.cleanarch.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class CleanArchApplication : Application(), HasActivityInjector {

    lateinit var applicationComponent: ApplicationComponent

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        instance = this
        buildComponent()
    }

    override fun activityInjector(): AndroidInjector<Activity> = dispatchingActivityInjector

    private fun buildComponent() {
        applicationComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .build()
        applicationComponent.inject(this)
    }

    companion object {
        lateinit var instance: CleanArchApplication private set
    }
}
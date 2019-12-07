package com.nish.android.cleanarch.di

import com.nish.android.cleanarch.activity.MainActivity
import com.nish.android.cleanarch.activity.NewHotelActivity
import com.nish.android.cleanarch.activity.TutorialActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityModule() {

    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity

    @ContributesAndroidInjector
    abstract fun bindNewHotelActivity() : NewHotelActivity
}
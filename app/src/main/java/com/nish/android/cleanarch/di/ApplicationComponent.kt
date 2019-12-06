package com.nish.android.cleanarch.di

import com.nish.android.cleanarch.CleanArchApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, AndroidInjectionModule::class, ActivityModule::class, NetworkModule::class])
interface ApplicationComponent : AndroidInjector<CleanArchApplication>
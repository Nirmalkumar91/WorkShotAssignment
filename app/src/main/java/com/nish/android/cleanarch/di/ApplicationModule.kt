package com.nish.android.cleanarch.di

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nish.android.cleanarch.network.HotelService
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class ApplicationModule(private val app: Application) {

    @Provides
    @Singleton
    fun provideApplication(): Application {
        return app
    }

    @Provides
    fun provideContext(): Context {
        return app
    }

    @Provides
    fun provideSharedPreferences(): SharedPreferences {
        return app.getSharedPreferences("nish-preference", Context.MODE_PRIVATE)
    }
}
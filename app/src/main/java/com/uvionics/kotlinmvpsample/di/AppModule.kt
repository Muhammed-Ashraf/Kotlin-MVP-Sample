package com.uvionics.kotlinmvpsample.di

import android.app.Application
import android.content.Context
import com.uvionics.kotlinmvpsample.BuildConfig
import com.uvionics.kotlinmvpsample.data.network.NetworkApiHelper
import com.uvionics.kotlinmvpsample.util.AppConstants
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    internal fun provideContext(application: Application): Context = application


    @Provides
    internal fun provideprefFileName(): String = AppConstants.PREF_NAME
    //TODO
//    @Provides
//    @Singleton
//    internal fun providePrefHelper(appPreferenceHelper: AppPreferenceHelper)
//            : PreferenceHelper = appPreferenceHelper

    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable = CompositeDisposable()


    @Provides
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }

    @Provides
    internal fun providePostApi(retrofit: Retrofit): NetworkApiHelper {
        return retrofit.create(NetworkApiHelper::class.java)
    }
}
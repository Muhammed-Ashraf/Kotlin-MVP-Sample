package com.uvionics.kotlinmvpsample

import android.app.Activity
import android.app.Application
import com.uvionics.kotlinmvpsample.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class KotlinMVPSampleApplication : Application(), HasActivityInjector {

    @Inject
    lateinit internal var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.builder().application(this).build().inject(this)
    }

    override fun activityInjector() = activityDispatchingAndroidInjector

}
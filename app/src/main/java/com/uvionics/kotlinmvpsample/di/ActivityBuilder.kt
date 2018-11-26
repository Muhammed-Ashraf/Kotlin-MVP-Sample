package com.uvionics.kotlinmvpsample.di

import com.uvionics.kotlinmvpsample.ui.apicall.ApiCallFragmentModule
import com.uvionics.kotlinmvpsample.ui.apicall.ApiCallFragmentProvider
import com.uvionics.kotlinmvpsample.ui.main.MainActivityModule
import com.uvionics.kotlinmvpsample.ui.main.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

    @ContributesAndroidInjector(modules = [(MainActivityModule::class), (ApiCallFragmentProvider::class)])
    abstract fun bindMainActivity(): MainActivity

}
package com.uvionics.kotlinmvpsample.di

import android.app.Application
import com.uvionics.kotlinmvpsample.KotlinMVPSampleApplication
import com.uvionics.kotlinmvpsample.ui.main.MainActivityModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [(AndroidSupportInjectionModule::class), (AppModule::class), (ActivityBuilder::class)]) //TODO
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(app: KotlinMVPSampleApplication)
}
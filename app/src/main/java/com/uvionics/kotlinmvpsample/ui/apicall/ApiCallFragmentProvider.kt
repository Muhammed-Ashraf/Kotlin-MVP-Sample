package com.uvionics.kotlinmvpsample.ui.apicall

import com.uvionics.kotlinmvpsample.ui.apicall.view.ApiCallFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * Created by jyotidubey on 14/01/18.
 */
@Module
internal abstract class ApiCallFragmentProvider {

    @ContributesAndroidInjector(modules = [ApiCallFragmentModule::class])
    internal abstract fun provideApicallFragmentFactory(): ApiCallFragment
}
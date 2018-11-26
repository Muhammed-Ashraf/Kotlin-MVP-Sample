package com.uvionics.kotlinmvpsample.ui.main

import com.uvionics.kotlinmvpsample.ui.main.interactor.MainInteractor
import com.uvionics.kotlinmvpsample.ui.apicall.interactor.ApiCallMVPInteractor
import com.uvionics.kotlinmvpsample.ui.main.interactor.MainMVPInteractor
import com.uvionics.kotlinmvpsample.ui.main.presentor.MainMVPPresenter
import com.uvionics.kotlinmvpsample.ui.main.presentor.MainPresenter
import com.uvionics.kotlinmvpsample.ui.main.view.MainMVPView
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    internal fun provideMainInteractor(mainInteractor: MainInteractor): MainMVPInteractor = mainInteractor

    @Provides
    internal fun provideMainPresenter(mainPresenter: MainPresenter<MainMVPView, MainMVPInteractor>)
            : MainMVPPresenter<MainMVPView, MainMVPInteractor> = mainPresenter

}
package com.uvionics.kotlinmvpsample.ui.main.presentor

import com.uvionics.kotlinmvpsample.ui.base.presenter.MVPPresenter
import com.uvionics.kotlinmvpsample.ui.apicall.interactor.ApiCallMVPInteractor
import com.uvionics.kotlinmvpsample.ui.main.interactor.MainMVPInteractor
import com.uvionics.kotlinmvpsample.ui.main.view.MainMVPView

interface MainMVPPresenter<V : MainMVPView, I : MainMVPInteractor> : MVPPresenter<V, I> {

//    fun refreshQuestionCards(): Boolean?
//    fun onDrawerOptionAboutClick() : Unit?
//    fun onDrawerOptionRateUsClick(): Unit?
//    fun onDrawerOptionFeedClick(): Unit?
//    fun onDrawerOptionLogoutClick()

}
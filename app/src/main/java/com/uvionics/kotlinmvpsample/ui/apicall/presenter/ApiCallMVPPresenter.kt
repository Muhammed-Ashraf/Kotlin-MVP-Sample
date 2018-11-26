package com.uvionics.kotlinmvpsample.ui.apicall.presenter


import com.uvionics.kotlinmvpsample.ui.apicall.interactor.ApiCallInteractor
import com.uvionics.kotlinmvpsample.ui.apicall.interactor.ApiCallMVPInteractor
import com.uvionics.kotlinmvpsample.ui.apicall.view.ApiCallMVPView
import com.uvionics.kotlinmvpsample.ui.base.presenter.MVPPresenter

/**
 * Created by jyotidubey on 13/01/18.
 */
interface ApiCallMVPPresenter<V : ApiCallMVPView, I : ApiCallMVPInteractor> : MVPPresenter<V, I> {

    fun onViewPrepared()
}
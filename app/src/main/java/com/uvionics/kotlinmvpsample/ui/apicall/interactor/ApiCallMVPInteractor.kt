package com.uvionics.kotlinmvpsample.ui.apicall.interactor

import com.uvionics.kotlinmvpsample.model.PostModel
import com.uvionics.kotlinmvpsample.ui.base.interactor.MVPInteractor
import io.reactivex.Observable

interface ApiCallMVPInteractor : MVPInteractor {

    fun dogetPostsApiCall(): Observable<List<PostModel>>
}